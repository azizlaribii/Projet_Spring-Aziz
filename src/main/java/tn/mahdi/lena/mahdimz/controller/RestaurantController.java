package tn.mahdi.lena.mahdimz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.mahdi.lena.mahdimz.services.IRestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
}
