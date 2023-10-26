package com.jyujyu.review.repository;

import com.jyujyu.review.model.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<RestaurantMenu,Long> {
    public List<RestaurantMenu> findAllByRestaurantId(Long id);
}
