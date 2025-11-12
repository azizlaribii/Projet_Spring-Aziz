package tn.mahdi.lena.mahdimz.services;

import org.springframework.stereotype.Service;
import tn.mahdi.lena.mahdimz.Entity.Composant;
import tn.mahdi.lena.mahdimz.repository.ComposantRepository;

import java.util.List;

@Service
public class ComposantService implements IComposantService {

    private final ComposantRepository composantRepository;

    public ComposantService(ComposantRepository composantRepository) {
        this.composantRepository = composantRepository;
    }

    @Override
    public List<Composant> retrieveAllComposants() {
        return composantRepository.findAll();
    }

    @Override
    public Composant addComposant(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Composant updateComposant(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Composant retrieveComposant(Long idComposant) {
        return composantRepository.findById(idComposant).orElse(null);
    }

    @Override
    public void removeComposant(Long idComposant) {
        composantRepository.deleteById(idComposant);
    }
}
