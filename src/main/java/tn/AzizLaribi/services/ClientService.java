package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import tn.AzizLaribi.Entity.Client;
import tn.AzizLaribi.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client e) {
        return clientRepository.save(e);
    }

    @Override
    public Client updateClient(Client e) {
        return clientRepository.save(e);//save method in jpa repository is used for both add and update
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        clientRepository.deleteById(idClient);

    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    @Override
    public Client findByIdentifiant(String identifiant) {
        return clientRepository.findByIdentifiant(identifiant).orElse(null);
    }

    @Override
    public List<Client> findClientsFirstVisitBetween(java.time.LocalDate start, java.time.LocalDate end) {
        return clientRepository.findClientsFirstVisitBetween(start, end);
    }
}
