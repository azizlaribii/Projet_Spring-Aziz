package tn.mahdi.lena.mahdimz.services;

import tn.mahdi.lena.mahdimz.Entity.Composant;

import java.util.List;

public interface IComposantService {

    List<Composant> retrieveAllComposants();
    Composant addComposant(Composant composant);
    Composant updateComposant(Composant composant);
    Composant retrieveComposant(Long idComposant);
    void removeComposant(Long idComposant);
}
