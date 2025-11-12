package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import tn.AzizLaribi.Entity.ChefCuisinier;
import tn.AzizLaribi.repository.ChefCuisinierRepository;

import java.util.List;

@Service
public class ChefCuisinierService implements IChefCuisinierService {

    private final ChefCuisinierRepository chefCuisinierRepository;

    public ChefCuisinierService(ChefCuisinierRepository chefCuisinierRepository) {
        this.chefCuisinierRepository = chefCuisinierRepository;
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
}
