package com.jyujyu.review.service;

import com.jyujyu.review.model.Review;
import com.jyujyu.review.repository.RestaurantRepository;
import com.jyujyu.review.repository.ReviewRepository;
import com.jyujyu.review.service.dto.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository repository;

    @Transactional
    public void createReview(Long restaurantId,String content,Double score){
        restaurantRepository.findById(restaurantId).orElseThrow();

        Review review = Review.builder()
                .restaurantId(restaurantId)
                .content(content)
                .score(score)
                .createdAt(ZonedDateTime.now())
                .build();
        repository.save(review);
    }

    public void deleteReview(Long reviewId){
        Review review = repository.findById(reviewId).orElseThrow();
        repository.delete(review);
    }

    public ReviewDto getRestaurantReview(Long restaurantId, Pageable pageable){
        Double avgScore = repository.getAvgScoreByRestaurantId(restaurantId);
        Slice<Review> reviews = repository.findSliceByRestaurantId(restaurantId, pageable);

        return ReviewDto.builder()
                .avgScore(avgScore)
                .reviews(reviews.getContent())
                .pageDto(
                        ReviewDto.pageDto.builder()
                                .offset(pageable.getPageNumber() * pageable.getPageSize())
                                .limit(pageable.getPageSize())
                                .build()
                )
                .build();
    }
}
