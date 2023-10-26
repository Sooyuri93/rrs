package com.jyujyu.review.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@Table(name = "restaurant_menu")
@Entity
@NoArgsConstructor
@Getter
public class RestaurantMenu {
    @Id
    @GeneratedValue
    private Long id;
    private Long restaurantId;

    private String name;
    private int price;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
