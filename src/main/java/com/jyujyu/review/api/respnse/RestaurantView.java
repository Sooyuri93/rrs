package com.jyujyu.review.api.respnse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Builder
@AllArgsConstructor
@Getter
public class RestaurantView {
    private final Long id;
    private final String name;
    private final String address;
    private final ZonedDateTime createdsAt;
    private final ZonedDateTime updatedAt;
}
