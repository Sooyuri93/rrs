package com.jyujyu.review.api;

import com.jyujyu.review.api.reqeust.CreateReviewRequest;
import com.jyujyu.review.api.response.RestaurantView;
import com.jyujyu.review.service.ReviewService;
import com.jyujyu.review.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewApi {
    private final ReviewService service;

    @PostMapping("/review")
    public void getRestaurants(@RequestBody CreateReviewRequest createReviewRequest){
        service.createReview(createReviewRequest.getRestaurantId(), createReviewRequest.getContent(), createReviewRequest.getScore());
    }

    @DeleteMapping("/review/{reviewId}")
    public void getRestaurants(@PathVariable Long reviewId){
        service.deleteReview(reviewId);
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ReviewDto getRestaurantReview(@PathVariable Long restaurantId,
                                         @RequestParam("offset") Integer offset,
                                         @RequestParam("limit") Integer limit
    ){
        return service.getRestaurantReview(restaurantId, PageRequest.of(offset/limit,limit));
    }
}
