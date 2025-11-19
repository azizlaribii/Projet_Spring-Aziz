package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.AzizLaribi.Entity.ChaineRestauration;
import java.util.Optional;

public interface ChaineRestaurationRepository extends JpaRepository<ChaineRestauration, Long> {
    Optional<ChaineRestauration> findByLibelle(String libelle);
}