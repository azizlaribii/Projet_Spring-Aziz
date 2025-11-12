package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.Commande;

import java.util.List;

public interface ICommandeService {

    List<Commande> retrieveAllCommandes();
    Commande addCommande(Commande commande);
    Commande updateCommande(Commande commande);
    Commande retrieveCommande(Long idCommande);
    void removeCommande(Long idCommande);
}
