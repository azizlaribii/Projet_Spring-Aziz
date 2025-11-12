package tn.AzizLaribi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.AzizLaribi.Entity.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlacesMax, java.time.LocalDate before);
}
