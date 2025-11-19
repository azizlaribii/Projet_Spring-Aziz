package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.AzizLaribi.Entity.Composant;

public interface ComposantRepository extends JpaRepository<Composant, Long> {
}