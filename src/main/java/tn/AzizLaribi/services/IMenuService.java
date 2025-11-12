package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.Menu;

import java.util.List;

public interface IMenuService {

    List<Menu> retrieveAllMenus();
    Menu addMenu(Menu menu);
    Menu updateMenu(Menu menu);
    Menu retrieveMenu(Long idMenu);
    void removeMenu(Long idMenu);
    java.util.List<Menu> findByTypeMenuAndPrixTotalGreaterThan(tn.AzizLaribi.Entity.TypeMenu type, Float prixMin);
    java.util.List<Menu> findMenusByTypeWithComposantPriceGreaterThan(tn.AzizLaribi.Entity.TypeMenu type, Float prix);
}
