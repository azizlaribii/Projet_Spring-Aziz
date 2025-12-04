package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    public String ajouterEmploye(String nom) {
        System.out.println(">>> Service : ajout employé");
        return "Employé ajouté : " + nom;
    }

    public void supprimerEmploye(int id) {
        System.out.println(">>> Service : suppression employé");
        if (id == 0) throw new RuntimeException("ID invalide");
    }
}
