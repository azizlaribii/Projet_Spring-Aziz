package tn.mahdi.lena.mahdimz.services;

import tn.mahdi.lena.mahdimz.Entity.Restaurant;

import java.util.List;

public interface IRestaurantService {

    List<Restaurant> retrieveAllRestaurants();
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    Restaurant retrieveRestaurant(Long idRestaurant);
    void removeRestaurant(Long idRestaurant);
}
