package tn.AzizLaribi.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;

    private String nom;

    private Long nbPlacesMax;

    @ManyToOne
    @JoinColumn(name = "chaine_id")
    private ChaineRestauration chaineRestauration;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    public Restaurant() {}

    public Restaurant(String nom, Long nbPlacesMax) {
        this.nom = nom;
        this.nbPlacesMax = nbPlacesMax;
    }

    // Getters and Setters
    public Long getIdRestaurant() { return idRestaurant; }
    public void setIdRestaurant(Long idRestaurant) { this.idRestaurant = idRestaurant; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Long getNbPlacesMax() { return nbPlacesMax; }
    public void setNbPlacesMax(Long nbPlacesMax) { this.nbPlacesMax = nbPlacesMax; }
    public ChaineRestauration getChaineRestauration() { return chaineRestauration; }
    public void setChaineRestauration(ChaineRestauration chaineRestauration) { this.chaineRestauration = chaineRestauration; }
    public List<Menu> getMenus() { return menus; }
    public void setMenus(List<Menu> menus) { this.menus = menus; }

    @Override
    public String toString() {
        return "Restaurant{" +
                "idRestaurant=" + idRestaurant +
                ", nom='" + nom + '\'' +
                ", nbPlacesMax=" + nbPlacesMax +
                '}';
    }
}