package tn.AzizLaribi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;//diff between long and Long is that Long is an object and long is a primitive type

    @Column(unique = true, nullable = false)
    private String identifiant;

    private LocalDate datePremiereVisite;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // prevent LazyInitializationException on serialization
    private List<Commande> commandes = new ArrayList<>();

    // Default constructor (required by JPA)
    public Client() {
    }

    // Constructor with parameters
    public Client(String identifiant, LocalDate datePremiereVisite) {
        this.identifiant = identifiant;
        this.datePremiereVisite = datePremiereVisite;
    }

    // Getters and Setters
    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public LocalDate getDatePremiereVisite() {
        return datePremiereVisite;
    }

    public void setDatePremiereVisite(LocalDate datePremiereVisite) {
        this.datePremiereVisite = datePremiereVisite;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    // toString method (optional but useful for debugging)
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", identifiant='" + identifiant + '\'' +
                ", datePremiereVisite=" + datePremiereVisite +
                '}';
    }
}