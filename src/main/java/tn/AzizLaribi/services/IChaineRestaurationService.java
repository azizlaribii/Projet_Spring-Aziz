package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.ChaineRestauration;
import java.util.List;

public interface IChaineRestaurationService {
    List<ChaineRestauration> retrieveAllChaines();
    ChaineRestauration addChaine(ChaineRestauration chaineRestauration);
    ChaineRestauration updateChaine(ChaineRestauration chaineRestauration);
    ChaineRestauration retrieveChaine(Long idChaine);
    void removeChaine(Long idChaine);
}