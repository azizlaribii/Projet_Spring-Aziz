package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.Commande;
import tn.AzizLaribi.Entity.Client;
import java.time.LocalDate;
import java.util.List;

public interface ICommandeService {
    List<Commande> retrieveAllCommandes();
    Commande addCommande(Commande commande);
    Commande updateCommande(Commande commande);
    Commande retrieveCommande(Long idCommande);
    void removeCommande(Long idCommande);

    // Méthodes supplémentaires
    List<Commande> findByClient(Client client);
    List<Commande> findByClientAndDateCommandeBetween(Client client, LocalDate startDate, LocalDate endDate);
    List<Commande> findByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate);

    // Méthode du PDF
    void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu);
}