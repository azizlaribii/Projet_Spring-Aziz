package tn.AzizLaribi.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chef_cuisiniers")
public class ChefCuisinier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChefCuisinier;

    private String nom;

    private String prenom;

    @Enumerated(EnumType.STRING)
    private TypeChef typeChef;

    @ManyToMany(mappedBy = "chefs")
    private Set<Menu> menus = new HashSet<>();

    public ChefCuisinier() {}

    public ChefCuisinier(String nom, String prenom, TypeChef typeChef) {
        this.nom = nom;
        this.prenom = prenom;
        this.typeChef = typeChef;
    }

    public Long getIdChefCuisinier() {
        return idChefCuisinier;
    }

    public void setIdChefCuisinier(Long idChefCuisinier) {
        this.idChefCuisinier = idChefCuisinier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeChef getTypeChef() {
        return typeChef;
    }

    public void setTypeChef(TypeChef typeChef) {
        this.typeChef = typeChef;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "ChefCuisinier{" +
                "idChefCuisinier=" + idChefCuisinier +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", typeChef=" + typeChef +
                '}';
    }
}

