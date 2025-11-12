package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import tn.AzizLaribi.Entity.ChaineRestauration;
import tn.AzizLaribi.repository.ChaineRestaurationRepository;

import java.util.List;

@Service
public class ChaineRestaurationService implements IChaineRestaurationService {

    private final ChaineRestaurationRepository chaineRestaurationRepository;

    public ChaineRestaurationService(ChaineRestaurationRepository chaineRestaurationRepository) {
        this.chaineRestaurationRepository = chaineRestaurationRepository;
    }

    @Override
    public List<ChaineRestauration> retrieveAllChaines() {
        return chaineRestaurationRepository.findAll();
    }

    @Override
    public ChaineRestauration addChaine(ChaineRestauration chaineRestauration) {
        return chaineRestaurationRepository.save(chaineRestauration);
    }

    @Override
    public ChaineRestauration updateChaine(ChaineRestauration chaineRestauration) {
        return chaineRestaurationRepository.save(chaineRestauration);
    }

    @Override
    public ChaineRestauration retrieveChaine(Long idChaine) {
        return chaineRestaurationRepository.findById(idChaine).orElse(null);
    }

    @Override
    public void removeChaine(Long idChaine) {
        chaineRestaurationRepository.deleteById(idChaine);
    }
}
