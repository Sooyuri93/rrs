package com.jyujyu.review.api;

import com.jyujyu.review.api.reqeust.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.respnse.RestaurantDetailView;
import com.jyujyu.review.api.respnse.RestaurantView;
import com.jyujyu.review.model.Restaurant;
import com.jyujyu.review.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantApi {

    private final RestaurantService service;

    @GetMapping("/restaurants")
    public List<RestaurantView> getRestaurants(){
        return service.getRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDetailView getRestaurant(
            @PathVariable Long restaurantId
    ){
        return service.getRestaurant(restaurantId);
    }

    @PostMapping("/restaurant")
    public void createRestaurant(@RequestBody CreateAndEditRestaurantRequest request){
        service.createRestaurant(request);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public void editRestaurant(@PathVariable Long restaurantId, @RequestBody CreateAndEditRestaurantRequest request){
        service.editRestaurant(restaurantId,request);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId){
        service.deleteRestaurant(restaurantId);
    }
}
