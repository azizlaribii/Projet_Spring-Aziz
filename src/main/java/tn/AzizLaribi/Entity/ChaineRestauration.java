package tn.AzizLaribi.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chaines_restauration")
public class ChaineRestauration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChaineRestauration;

    private String libelle;

    private LocalDate dateCreation;

    @OneToMany(mappedBy = "chaineRestauration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<>();

    public ChaineRestauration() {}

    public ChaineRestauration(String libelle, LocalDate dateCreation) {
        this.libelle = libelle;
        this.dateCreation = dateCreation;
    }

    public Long getIdChaineRestauration() {
        return idChaineRestauration;
    }

    public void setIdChaineRestauration(Long idChaineRestauration) {
        this.idChaineRestauration = idChaineRestauration;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public String toString() {
        return "ChaineRestauration{" +
                "idChaineRestauration=" + idChaineRestauration +
                ", libelle='" + libelle + '\'' +
                ", dateCreation=" + dateCreation +
                '}';
    }
}

