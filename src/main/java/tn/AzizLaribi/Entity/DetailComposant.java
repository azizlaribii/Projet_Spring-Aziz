package tn.AzizLaribi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_composants")
public class DetailComposant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailComposant;

    private Float imc;

    @Enumerated(EnumType.STRING)
    private TypeComposant typeComposant;

    public DetailComposant() {}

    public DetailComposant(Float imc, TypeComposant typeComposant) {
        this.imc = imc;
        this.typeComposant = typeComposant;
    }

    public Long getIdDetailComposant() {
        return idDetailComposant;
    }

    public void setIdDetailComposant(Long idDetailComposant) {
        this.idDetailComposant = idDetailComposant;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public TypeComposant getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(TypeComposant typeComposant) {
        this.typeComposant = typeComposant;
    }

    @Override
    public String toString() {
        return "DetailComposant{" +
                "idDetailComposant=" + idDetailComposant +
                ", imc=" + imc +
                ", typeComposant=" + typeComposant +
                '}';
    }
}
