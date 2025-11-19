package tn.AzizLaribi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.AzizLaribi.Entity.Client;
import tn.AzizLaribi.services.IClientService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "CRUD et recherches pour les clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @Operation(description = "Récupérer tous les clients")
    @GetMapping
    public List<Client> getAll() {
        return clientService.retrieveAllClients();
    }

    @Operation(description = "Récupérer un client par ID")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getOne(@PathVariable("id") Long id) {
        Client c = clientService.retrieveClient(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @Operation(description = "Ajouter un nouveau client")
    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client saved = clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(description = "Mettre à jour un client")
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client client) {
        Client existing = clientService.retrieveClient(id);
        if (existing == null) return ResponseEntity.notFound().build();
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @Operation(description = "Supprimer un client")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Client existing = clientService.retrieveClient(id);
        if (existing == null) return ResponseEntity.notFound().build();
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "Chercher un client par son identifiant")
    @GetMapping("/by-identifiant/{identifiant}")
    public ResponseEntity<Client> getByIdentifiant(@PathVariable String identifiant) {
        Client c = clientService.findByIdentifiant(identifiant);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }

    @Operation(description = "Lister les clients dont la première visite est entre deux dates")
    @GetMapping("/first-visit")
    public List<Client> getByFirstVisitBetween(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return clientService.findClientsFirstVisitBetween(start, end);
    }
}
