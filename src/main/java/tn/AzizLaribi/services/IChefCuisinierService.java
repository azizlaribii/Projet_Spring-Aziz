package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.ChefCuisinier;

import java.util.List;

public interface IChefCuisinierService {

    List<ChefCuisinier> retrieveAllChefs();
    ChefCuisinier addChef(ChefCuisinier chefCuisinier);
    ChefCuisinier updateChef(ChefCuisinier chefCuisinier);
    ChefCuisinier retrieveChef(Long idChef);
    void removeChef(Long idChef);
}
