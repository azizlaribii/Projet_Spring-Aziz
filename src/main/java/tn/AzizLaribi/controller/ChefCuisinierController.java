package tn.AzizLaribi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.AzizLaribi.services.IChefCuisinierService;

@RestController
@RequestMapping("/chefs")
public class ChefCuisinierController {

    private final IChefCuisinierService chefCuisinierService;

    public ChefCuisinierController(IChefCuisinierService chefCuisinierService) {
        this.chefCuisinierService = chefCuisinierService;
    }
}
