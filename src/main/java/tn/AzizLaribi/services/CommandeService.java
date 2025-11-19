package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.AzizLaribi.Entity.*;
import tn.AzizLaribi.repository.CommandeRepository;
import tn.AzizLaribi.repository.ClientRepository;
import tn.AzizLaribi.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CommandeService implements ICommandeService {

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final MenuRepository menuRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           ClientRepository clientRepository,
                           MenuRepository menuRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande retrieveCommande(Long idCommande) {
        return commandeRepository.findById(idCommande).orElse(null);
    }

    @Override
    public void removeCommande(Long idCommande) {
        commandeRepository.deleteById(idCommande);
    }

    @Override
    public List<Commande> findByClient(Client client) {
        return commandeRepository.findByClient(client);
    }

    @Override
    public List<Commande> findByClientAndDateCommandeBetween(Client client, LocalDate startDate, LocalDate endDate) {
        return commandeRepository.findByClientAndDateCommandeBetween(client, startDate, endDate);
    }

    @Override
    public List<Commande> findByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate) {
        return commandeRepository.findByDateCommandeBetweenOrderByNoteDesc(startDate, endDate);
    }

    @Override
    public void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        // Trouver le client
        Client client = clientRepository.findByIdentifiant(identifiant)
                .orElseThrow(() -> new RuntimeException("Client non trouvé: " + identifiant));

        // Trouver le menu
        Menu menu = menuRepository.findByLibelleMenu(libelleMenu)
                .orElseThrow(() -> new RuntimeException("Menu non trouvé: " + libelleMenu));

        // Calculer les totaux
        Float prixMenu = menu.getPrixTotal();
        Integer pourcentageRemise = commande.getPourcentageRemise();

        Float totalRemise = prixMenu * pourcentageRemise / 100;
        Float totalCommande = prixMenu - totalRemise;

        // Mettre à jour la commande
        commande.setTotalRemise(totalRemise);
        commande.setTotalCommande(totalCommande);
        commande.setClient(client);
        commande.setMenu(menu);

        commandeRepository.save(commande);
    }
}