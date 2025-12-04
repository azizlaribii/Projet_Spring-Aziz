package tn.AzizLaribi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.AzizLaribi.services.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/add")
    public String addEmploye(@RequestParam String nom) {
        return employeService.ajouterEmploye(nom);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmploye(@PathVariable int id) {
        employeService.supprimerEmploye(id);
        return "Employé supprimé";
    }
}
