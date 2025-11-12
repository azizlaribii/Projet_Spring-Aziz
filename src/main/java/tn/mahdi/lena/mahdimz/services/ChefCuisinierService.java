package tn.mahdi.lena.mahdimz.services;

import org.springframework.stereotype.Service;
import tn.mahdi.lena.mahdimz.Entity.ChefCuisinier;
import tn.mahdi.lena.mahdimz.repository.ChefCuisinierRepository;

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
