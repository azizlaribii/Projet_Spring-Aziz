package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.Client;
import java.time.LocalDate;
import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client addClient(Client e);
    Client updateClient(Client e);
    Client retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<Client> addClients(List<Client> clients);

    // Méthodes personnalisées
    Client findByIdentifiant(String identifiant);
    List<Client> findClientsFirstVisitBetween(LocalDate start, LocalDate end);
}