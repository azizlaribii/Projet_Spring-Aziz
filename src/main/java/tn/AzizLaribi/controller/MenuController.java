package tn.AzizLaribi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.AzizLaribi.Entity.Menu;
import tn.AzizLaribi.Entity.TypeMenu;
import tn.AzizLaribi.services.IMenuService;

import java.util.List;

@RestController
@RequestMapping("/menus")
@Tag(name = "Menus", description = "CRUD et recherches pour les menus")
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    // CRUD
    @Operation(description = "Récupérer tous les menus")
    @GetMapping
    public List<Menu> getAll() { return menuService.retrieveAllMenus(); }

    @Operation(description = "Récupérer un menu par ID")
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getOne(@PathVariable("id") Long id) {
        Menu m = menuService.retrieveMenu(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @Operation(description = "Ajouter un nouveau menu")
    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody Menu menu) {
        Menu saved = menuService.addMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @Operation(description = "Mettre à jour un menu")
    @PutMapping("/{id}")
    public ResponseEntity<Menu> update(@PathVariable("id") Long id, @RequestBody Menu menu) {
        Menu existing = menuService.retrieveMenu(id);
        if (existing == null) return ResponseEntity.notFound().build();
        menu.setIdMenu(id);
        return ResponseEntity.ok(menuService.updateMenu(menu));
    }

    @Operation(description = "Supprimer un menu")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Menu existing = menuService.retrieveMenu(id);
        if (existing == null) return ResponseEntity.notFound().build();
        menuService.removeMenu(id);
        return ResponseEntity.noContent().build();
    }

    // Keyword (derived) query: by type and minimal total price
    @Operation(description = "Rechercher menus par type et prix total minimum")
    @GetMapping("/search/byTypeAndMinTotal")
    public List<Menu> findByTypeAndMinTotal(@RequestParam("type") TypeMenu type,
                                            @RequestParam("prixMin") Float prixMin) {
        return menuService.findByTypeMenuAndPrixTotalGreaterThan(type, prixMin);
    }

    // JPQL query: type and any composant with price greater than value
    @Operation(description = "Rechercher menus par type et prix minimum d'un composant")
    @GetMapping("/search/byTypeAndComposantMinPrice")
    public List<Menu> findByTypeAndComposantMin(@RequestParam("type") TypeMenu type,
                                                @RequestParam("prix") Float prix) {
        return menuService.findMenusByTypeWithComposantPriceGreaterThan(type, prix);
    }
}
