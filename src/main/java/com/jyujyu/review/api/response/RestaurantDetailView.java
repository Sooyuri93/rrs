package com.jyujyu.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class RestaurantDetailView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createdsAt;
    private final ZonedDateTime updatedAt;
    private final List<Menu> menus;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Menu{
        private final Long id;
        private final String name;
        private final int price;
        private final ZonedDateTime createdAt;
        private final ZonedDateTime updatedAt;
    }
}
