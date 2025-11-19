package tn.AzizLaribi.services;

import tn.AzizLaribi.Entity.Restaurant;
import java.util.List;

public interface IRestaurantService {
    List<Restaurant> retrieveAllRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    Restaurant retrieveRestaurant(Long idRestaurant);
    void removeRestaurant(Long idRestaurant);

    // Méthodes du PDF
    Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine);
    Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant);

    // Méthode supplémentaire
    List<Restaurant> findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlacesMax, java.time.LocalDate before);
}