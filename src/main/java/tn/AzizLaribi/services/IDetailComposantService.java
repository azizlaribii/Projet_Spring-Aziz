package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.DetailComposant;

import java.util.List;

public interface IDetailComposantService {

    List<DetailComposant> retrieveAllDetailComposants();
    DetailComposant addDetailComposant(DetailComposant detailComposant);
    DetailComposant updateDetailComposant(DetailComposant detailComposant);
    DetailComposant retrieveDetailComposant(Long idDetailComposant);
    void removeDetailComposant(Long idDetailComposant);
}
