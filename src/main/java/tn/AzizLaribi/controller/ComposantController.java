package tn.AzizLaribi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.AzizLaribi.services.IComposantService;

@RestController
@RequestMapping("/composants")
public class ComposantController {

    private final IComposantService composantService;

    public ComposantController(IComposantService composantService) {
        this.composantService = composantService;
    }
}
