package tn.mahdi.lena.mahdimz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.mahdi.lena.mahdimz.services.ICommandeService;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final ICommandeService commandeService;

    public CommandeController(ICommandeService commandeService) {
        this.commandeService = commandeService;
    }
}
