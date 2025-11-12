package tn.AzizLaribi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.AzizLaribi.services.IChaineRestaurationService;

@RestController
@RequestMapping("/chaines")
public class ChaineRestaurationController {

    private final IChaineRestaurationService chaineRestaurationService;

    public ChaineRestaurationController(IChaineRestaurationService chaineRestaurationService) {
        this.chaineRestaurationService = chaineRestaurationService;
    }
}
