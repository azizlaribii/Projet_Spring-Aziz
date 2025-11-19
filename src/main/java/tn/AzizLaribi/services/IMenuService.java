package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.Menu;
import tn.AzizLaribi.Entity.Composant;
import tn.AzizLaribi.Entity.TypeMenu;
import java.util.List;
import java.util.Set;

public interface IMenuService {
    List<Menu> retrieveAllMenus();
    Menu addMenu(Menu menu);
    Menu updateMenu(Menu menu);
    Menu retrieveMenu(Long idMenu);
    void removeMenu(Long idMenu);

    // Méthodes de recherche
    List<Menu> findByTypeMenuAndPrixTotalGreaterThan(TypeMenu type, Float prixMin);
    List<Menu> findMenusByTypeWithComposantPriceGreaterThan(TypeMenu type, Float prix);

    // Méthode du PDF
    Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu);
}