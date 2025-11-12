package tn.mahdi.lena.mahdimz.services;

import tn.mahdi.lena.mahdimz.Entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client e);
    Client updateClient(Client e);
    Client retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<Client> addClients(List<Client> clients);
    Client findByIdentifiant(String identifiant);
    List<Client> findClientsFirstVisitBetween(java.time.LocalDate start, java.time.LocalDate end);
}
