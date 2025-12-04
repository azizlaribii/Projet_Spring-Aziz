package tn.AzizLaribi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.AzizLaribi.Entity.Menu;
import tn.AzizLaribi.Entity.Composant;
import tn.AzizLaribi.Entity.TypeMenu;
import tn.AzizLaribi.repository.MenuRepository;
import tn.AzizLaribi.repository.ComposantRepository;

import java.util.List;
import java.util.Set;

@Service
@Transactional
@Slf4j
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;
    private final ComposantRepository composantRepository;

    public MenuService(MenuRepository menuRepository,
                       ComposantRepository composantRepository) {
        this.menuRepository = menuRepository;
        this.composantRepository = composantRepository;
    }

    @Override
    public List<Menu> retrieveAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu retrieveMenu(Long idMenu) {
        return menuRepository.findById(idMenu).orElse(null);
    }

    @Override
    public void removeMenu(Long idMenu) {
        menuRepository.deleteById(idMenu);
    }

    @Override
    public List<Menu> findByTypeMenuAndPrixTotalGreaterThan(TypeMenu type, Float prixMin) {
        return menuRepository.findByTypeMenuAndPrixTotalGreaterThan(type, prixMin);
    }

    @Override
    public List<Menu> findMenusByTypeWithComposantPriceGreaterThan(TypeMenu type, Float prix) {
        return menuRepository.findMenusByTypeWithComposantPriceGreaterThan(type, prix);
    }

    @Override
    public Menu ajoutComposantsEtMiseAjourPrixMenu(Set<Composant> composants, Long idMenu) {
        Menu menu = menuRepository.findById(idMenu)
                .orElseThrow(() -> new RuntimeException("Menu non trouvé: " + idMenu));

        // Sauvegarder les nouveaux composants et les associer au menu
        for (Composant composant : composants) {
            composant.setMenu(menu);
            composantRepository.save(composant);
            menu.getComposants().add(composant);
        }

        // Calculer le nouveau prix total
        Float nouveauPrix = menu.getComposants().stream()
                .map(Composant::getPrix)
                .reduce(0.0f, Float::sum);

        // Vérifier la contrainte de prix maximum
        if (nouveauPrix > 20.0f) {
            throw new RuntimeException("Le prix total du menu ne doit pas dépasser 20 dinars. Prix calculé: " + nouveauPrix);
        }

        menu.setPrixTotal(nouveauPrix);
        return menuRepository.save(menu);
    }

}