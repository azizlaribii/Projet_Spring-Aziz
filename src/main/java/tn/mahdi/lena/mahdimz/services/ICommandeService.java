package tn.mahdi.lena.mahdimz.services;

import tn.mahdi.lena.mahdimz.Entity.Commande;

import java.util.List;

public interface ICommandeService {

    List<Commande> retrieveAllCommandes();
    Commande addCommande(Commande commande);
    Commande updateCommande(Commande commande);
    Commande retrieveCommande(Long idCommande);
    void removeCommande(Long idCommande);
}
