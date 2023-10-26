package com.jyujyu.review.service.dto;

import com.jyujyu.review.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class ReviewDto {
    private Double avgScore;
    private List<Review> reviews;
    private pageDto pageDto;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class pageDto{
        private Integer offset;
        private Integer limit;
    }
}
