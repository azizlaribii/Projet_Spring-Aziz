package tn.AzizLaribi.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.AzizLaribi.Entity.Restaurant;
import tn.AzizLaribi.Entity.ChaineRestauration;
import tn.AzizLaribi.repository.RestaurantRepository;
import tn.AzizLaribi.repository.ChaineRestaurationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RestaurantService implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ChaineRestaurationRepository chaineRestaurationRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             ChaineRestaurationRepository chaineRestaurationRepository) {
        this.restaurantRepository = restaurantRepository;
        this.chaineRestaurationRepository = chaineRestaurationRepository;
    }

    @Override
    public List<Restaurant> retrieveAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant retrieveRestaurant(Long idRestaurant) {
        return restaurantRepository.findById(idRestaurant).orElse(null);
    }

    @Override
    public void removeRestaurant(Long idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }

    @Override
    public Restaurant affecterRestaurantAChaineRestauration(String nomRestaurant, String libelleChaine) {
        // Récupérer le restaurant par son nom
        Restaurant restaurant = restaurantRepository.findByNom(nomRestaurant)
                .orElseThrow(() -> new RuntimeException("Restaurant introuvable : " + nomRestaurant));

        // Récupérer la chaîne par son libellé
        ChaineRestauration chaine = chaineRestaurationRepository.findByLibelle(libelleChaine)
                .orElseThrow(() -> new RuntimeException("Chaîne introuvable : " + libelleChaine));

        restaurant.setChaineRestauration(chaine);
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant ajoutRestaurantEtMenuAssocies(Restaurant restaurant) {
        // Si le restaurant a des menus associés, initialiser leurs prix à 0
        if (restaurant.getMenus() != null) {
            restaurant.getMenus().forEach(menu -> {
                menu.setPrixTotal(0.0f);
                menu.setRestaurant(restaurant);
            });
        }
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(Long nbPlacesMax, LocalDate before) {
        return restaurantRepository.findByNbPlacesMaxGreaterThanAndChaineRestaurationDateCreationBefore(nbPlacesMax, before);
    }
}