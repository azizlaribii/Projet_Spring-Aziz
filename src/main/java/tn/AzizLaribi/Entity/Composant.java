package tn.AzizLaribi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "composants")
public class Composant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComposant;

    private String nomComposant;

    private Float prix;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "detail_id")
    private DetailComposant detail;

    public Composant() {}

    public Composant(String nomComposant, Float prix) {
        this.nomComposant = nomComposant;
        this.prix = prix;
    }

    public Long getIdComposant() {
        return idComposant;
    }

    public void setIdComposant(Long idComposant) {
        this.idComposant = idComposant;
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public void setNomComposant(String nomComposant) {
        this.nomComposant = nomComposant;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public DetailComposant getDetail() {
        return detail;
    }

    public void setDetail(DetailComposant detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Composant{" +
                "idComposant=" + idComposant +
                ", nomComposant='" + nomComposant + '\'' +
                ", prix=" + prix +
                '}';
    }
}

