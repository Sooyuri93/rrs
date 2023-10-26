package com.jyujyu.review.repository;

import com.jyujyu.review.model.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReviewRepositoryCustom {

    Double getAvgScoreByRestaurantId(Long restaurantId);
    Slice<Review> findSliceByRestaurantId(Long restaurantId, Pageable pageable);
}
