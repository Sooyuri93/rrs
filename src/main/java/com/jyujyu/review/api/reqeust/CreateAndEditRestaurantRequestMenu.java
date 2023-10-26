package com.jyujyu.review.api.reqeust;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateAndEditRestaurantRequestMenu {
    private final String name;
    private final int price;
}
