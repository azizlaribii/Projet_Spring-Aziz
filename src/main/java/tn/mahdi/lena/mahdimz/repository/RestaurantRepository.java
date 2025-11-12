package tn.mahdi.lena.mahdimz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.mahdi.lena.mahdimz.Entity.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlacesMax, java.time.LocalDate before);
}
