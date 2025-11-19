package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.AzizLaribi.Entity.Restaurant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlacesMax, LocalDate before);

    Optional<Restaurant> findByNom(String nom);
}