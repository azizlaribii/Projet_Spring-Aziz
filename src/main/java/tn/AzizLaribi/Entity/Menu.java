package tn.AzizLaribi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMenu;

    private String libelleMenu;

    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;

    private Float prixTotal = 0.0f;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "chef_cuisinier_id")
    private ChefCuisinier chefCuisinier;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Composant> composants = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Commande> commandes = new ArrayList<>();

    public Menu() {}

    public Menu(String libelleMenu, TypeMenu typeMenu, Float prixTotal) {
        this.libelleMenu = libelleMenu;
        this.typeMenu = typeMenu;
        this.prixTotal = prixTotal;
    }

    // Getters and Setters
    public Long getIdMenu() { return idMenu; }
    public void setIdMenu(Long idMenu) { this.idMenu = idMenu; }
    public String getLibelleMenu() { return libelleMenu; }
    public void setLibelleMenu(String libelleMenu) { this.libelleMenu = libelleMenu; }
    public TypeMenu getTypeMenu() { return typeMenu; }
    public void setTypeMenu(TypeMenu typeMenu) { this.typeMenu = typeMenu; }
    public Float getPrixTotal() { return prixTotal; }
    public void setPrixTotal(Float prixTotal) { this.prixTotal = prixTotal; }
    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
    public ChefCuisinier getChefCuisinier() { return chefCuisinier; }
    public void setChefCuisinier(ChefCuisinier chefCuisinier) { this.chefCuisinier = chefCuisinier; }
    public List<Composant> getComposants() { return composants; }
    public void setComposants(List<Composant> composants) { this.composants = composants; }
    public List<Commande> getCommandes() { return commandes; }
    public void setCommandes(List<Commande> commandes) { this.commandes = commandes; }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu=" + idMenu +
                ", libelleMenu='" + libelleMenu + '\'' +
                ", typeMenu=" + typeMenu +
                ", prixTotal=" + prixTotal +
                '}';
    }
}