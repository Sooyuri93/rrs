package com.jyujyu.review.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@Table(name = "review")
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private int restaurantId;

    private String content;
    private double score;
    private ZonedDateTime createdAt;
}
