package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.AzizLaribi.Entity.ChefCuisinier;
import tn.AzizLaribi.Entity.Menu;
import tn.AzizLaribi.repository.ChefCuisinierRepository;
import tn.AzizLaribi.repository.MenuRepository;

import java.util.List;

@Service
@Transactional
public class ChefCuisinierService implements IChefCuisinierService {

    private final ChefCuisinierRepository chefCuisinierRepository;
    private final MenuRepository menuRepository;

    public ChefCuisinierService(ChefCuisinierRepository chefCuisinierRepository,
                                MenuRepository menuRepository) {
        this.chefCuisinierRepository = chefCuisinierRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<ChefCuisinier> retrieveAllChefs() {
        return chefCuisinierRepository.findAll();
    }

    @Override
    public ChefCuisinier addChef(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public ChefCuisinier updateChef(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public ChefCuisinier retrieveChef(Long idChef) {
        return chefCuisinierRepository.findById(idChef).orElse(null);
    }

    @Override
    public void removeChef(Long idChef) {
        chefCuisinierRepository.deleteById(idChef);
    }

    @Override
    public ChefCuisinier affecterChefCuisinierAMenu(Long idChefCuisinier, Long idMenu) {
        ChefCuisinier chef = chefCuisinierRepository.findById(idChefCuisinier)
                .orElseThrow(() -> new RuntimeException("Chef cuisinier non trouvé: " + idChefCuisinier));

        Menu menu = menuRepository.findById(idMenu)
                .orElseThrow(() -> new RuntimeException("Menu non trouvé: " + idMenu));

        menu.setChefCuisinier(chef);
        menuRepository.save(menu);

        return chef;
    }

    @Override
    public ChefCuisinier desaffecterChefCuisinierDuMenu(Long idMenu, Long idChefCuisinier) {
        Menu menu = menuRepository.findById(idMenu)
                .orElseThrow(() -> new RuntimeException("Menu non trouvé: " + idMenu));

        ChefCuisinier chef = chefCuisinierRepository.findById(idChefCuisinier)
                .orElseThrow(() -> new RuntimeException("Chef cuisinier non trouvé: " + idChefCuisinier));

        // Vérifier que le chef est bien affecté à ce menu
        if (menu.getChefCuisinier() == null || !menu.getChefCuisinier().getIdChefCuisinier().equals(chef.getIdChefCuisinier())) {
            throw new RuntimeException("Ce chef n'est pas affecté à ce menu");
        }

        menu.setChefCuisinier(null);
        menuRepository.save(menu);

        return chef;
    }
}