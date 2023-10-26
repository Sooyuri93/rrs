package com.jyujyu.review.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
@Table(name = "review")
@Entity
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private Long restaurantId;

    private String content;
    private Double score;
    private ZonedDateTime createdAt;
}
