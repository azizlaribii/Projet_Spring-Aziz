package tn.mahdi.lena.mahdimz.services;

import tn.mahdi.lena.mahdimz.Entity.DetailComposant;

import java.util.List;

public interface IDetailComposantService {

    List<DetailComposant> retrieveAllDetailComposants();
    DetailComposant addDetailComposant(DetailComposant detailComposant);
    DetailComposant updateDetailComposant(DetailComposant detailComposant);
    DetailComposant retrieveDetailComposant(Long idDetailComposant);
    void removeDetailComposant(Long idDetailComposant);
}
