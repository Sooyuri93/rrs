package com.jyujyu.review.repository;

import com.jyujyu.review.model.QTestEntity;
import com.jyujyu.review.model.TestEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestRepositoryImpl implements TestRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory
                .select(QTestEntity.testEntity)
                .from(QTestEntity.testEntity)
                .where(QTestEntity.testEntity.name.eq(name))
                .fetch();
    }
}
