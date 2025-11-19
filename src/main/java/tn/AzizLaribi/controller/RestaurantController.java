package tn.AzizLaribi.controller;

import org.springframework.web.bind.annotation.*;
import tn.AzizLaribi.Entity.Restaurant;
import tn.AzizLaribi.services.IRestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/ajoutAvecMenus")
    public Restaurant ajoutRestaurantEtMenuAssocies(@RequestBody Restaurant restaurant) {
        return restaurantService.ajoutRestaurantEtMenuAssocies(restaurant);
    }
}