package tn.mahdi.lena.mahdimz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.mahdi.lena.mahdimz.services.IDetailComposantService;

@RestController
@RequestMapping("/detail-composants")
public class DetailComposantController {

    private final IDetailComposantService detailComposantService;

    public DetailComposantController(IDetailComposantService detailComposantService) {
        this.detailComposantService = detailComposantService;
    }
}
