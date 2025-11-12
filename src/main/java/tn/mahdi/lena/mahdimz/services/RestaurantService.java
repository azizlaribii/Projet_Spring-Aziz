package tn.mahdi.lena.mahdimz.services;

import org.springframework.stereotype.Service;
import tn.mahdi.lena.mahdimz.Entity.Restaurant;
import tn.mahdi.lena.mahdimz.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService implements IRestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
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
}
