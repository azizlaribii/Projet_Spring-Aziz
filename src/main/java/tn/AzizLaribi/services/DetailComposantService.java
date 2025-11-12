package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import tn.AzizLaribi.Entity.DetailComposant;
import tn.AzizLaribi.repository.DetailComposantRepository;

import java.util.List;

@Service
public class DetailComposantService implements IDetailComposantService {

    private final DetailComposantRepository detailComposantRepository;

    public DetailComposantService(DetailComposantRepository detailComposantRepository) {
        this.detailComposantRepository = detailComposantRepository;
    }

    @Override
    public List<DetailComposant> retrieveAllDetailComposants() {
        return detailComposantRepository.findAll();
    }

    @Override
    public DetailComposant addDetailComposant(DetailComposant detailComposant) {
        return detailComposantRepository.save(detailComposant);
    }

    @Override
    public DetailComposant updateDetailComposant(DetailComposant detailComposant) {
        return detailComposantRepository.save(detailComposant);
    }

    @Override
    public DetailComposant retrieveDetailComposant(Long idDetailComposant) {
        return detailComposantRepository.findById(idDetailComposant).orElse(null);
    }

    @Override
    public void removeDetailComposant(Long idDetailComposant) {
        detailComposantRepository.deleteById(idDetailComposant);
    }
}
