package com.jyujyu.review.service;

import com.jyujyu.review.api.reqeust.CreateAndEditRestaurantRequest;
import com.jyujyu.review.api.reqeust.CreateAndEditRestaurantRequestMenu;
import com.jyujyu.review.api.respnse.RestaurantDetailView;
import com.jyujyu.review.api.respnse.RestaurantView;
import com.jyujyu.review.model.Restaurant;
import com.jyujyu.review.model.RestaurantMenu;
import com.jyujyu.review.repository.MenuRepository;
import com.jyujyu.review.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<RestaurantView> getRestaurants(){
        List<Restaurant> result = restaurantRepository.findAll();

        return result.stream().map((restaurant) -> RestaurantView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdsAt(restaurant.getCreatedAt())
                .updatedAt(restaurant.getUpdatedAt())
                .build())
                .toList();
    }

    public RestaurantDetailView getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();
        List<RestaurantMenu> menus = menuRepository.findAllByRestaurantId(restaurant.getId());
        return RestaurantDetailView.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .createdsAt(restaurant.getCreatedAt())
                .updatedAt(restaurant.getUpdatedAt())
                .menus(
                        menus.stream().map((menu) -> RestaurantDetailView.Menu.builder()
                                .id(menu.getId())
                                .name(menu.getName())
                                .price(menu.getPrice())
                                .createdsAt(menu.getCreatedAt())
                                .updatedAt(menu.getUpdatedAt())
                                .build())
                        .toList()
                )
                .build();
    }
    @Transactional
    public Restaurant createRestaurant(CreateAndEditRestaurantRequest restaurantRequest){
        Restaurant restaurant = Restaurant.builder()
                .name(restaurantRequest.getName())
                .address(restaurantRequest.getAddress())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
        Restaurant result = restaurantRepository.save(restaurant);

        restaurantRequest.getMenus().forEach((menu)->{
            RestaurantMenu menuResult = RestaurantMenu.builder()
                    .restaurantId(restaurant.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();
            menuRepository.save(menuResult);
        });

        return result;
    }

    @Transactional
    public void editRestaurant(Long id,CreateAndEditRestaurantRequest restaurantRequest){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("없는 레스토랑 입니다."));
        restaurant.changeNameAndAddress(restaurantRequest.getName(), restaurantRequest.getAddress());
        restaurantRepository.save(restaurant);

        List<RestaurantMenu> menus = menuRepository.findAllByRestaurantId(restaurant.getId());
        menuRepository.deleteAll(menus);

        restaurantRequest.getMenus().forEach((menu)->{
            RestaurantMenu menuResult = RestaurantMenu.builder()
                    .restaurantId(id)
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .createdAt(ZonedDateTime.now())
                    .updatedAt(ZonedDateTime.now())
                    .build();
            menuRepository.save(menuResult);
        });
    }

    @Transactional
    public void deleteRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow();
        restaurantRepository.delete(restaurant);

        List<RestaurantMenu> allByRestaurantId = menuRepository.findAllByRestaurantId(id);
        menuRepository.deleteAll(allByRestaurantId);
    }
}
