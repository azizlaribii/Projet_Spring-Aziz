package tn.mahdi.lena.mahdimz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.mahdi.lena.mahdimz.services.IChaineRestaurationService;

@RestController
@RequestMapping("/chaines")
public class ChaineRestaurationController {

    private final IChaineRestaurationService chaineRestaurationService;

    public ChaineRestaurationController(IChaineRestaurationService chaineRestaurationService) {
        this.chaineRestaurationService = chaineRestaurationService;
    }
}
