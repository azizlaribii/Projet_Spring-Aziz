package tn.AzizLaribi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employe") // nom de la table en base
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nom;


    public Employe() {}
    public Employe(String nom) {
        this.nom = nom;
    }

    // Getters / Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
