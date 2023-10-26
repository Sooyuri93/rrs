package com.jyujyu.review.repository;

import com.jyujyu.review.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
