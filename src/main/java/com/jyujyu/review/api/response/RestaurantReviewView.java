package com.jyujyu.review.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class RestaurantReviewView {
    private final Double avgScore;
    private final List<Review> reviews;
    private final Page page;

    @Builder
    @AllArgsConstructor
    @Getter
    public static class Review{
        private final Long id;
        private final String content;
        private final double score;
        private final ZonedDateTime createdAt;
    }
}
