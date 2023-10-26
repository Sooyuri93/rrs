package com.jyujyu.review.repository;

import com.jyujyu.review.model.QReview;
import com.jyujyu.review.model.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public Double getAvgScoreByRestaurantId(Long restaurantId) {
        return queryFactory
                .select(QReview.review.score.avg())
                .from(QReview.review)
                .where(QReview.review.id.eq(restaurantId))
                .fetchFirst();
    }

    @Override
    public Slice<Review> findSliceByRestaurantId(Long restaurantId, Pageable pageable) {
        List<Review> reviews = queryFactory
                .select(QReview.review)
                .from(QReview.review)
                .where(QReview.review.restaurantId.eq(restaurantId))
                .offset((long) pageable.getPageNumber() * pageable.getPageNumber())
                .limit(pageable.getPageSize() +1)
                .fetch();

        return new SliceImpl<>(
                reviews.stream().limit(pageable.getPageSize()).toList()
                ,pageable
                ,reviews.size() > pageable.getPageSize()
        );
    }
}
