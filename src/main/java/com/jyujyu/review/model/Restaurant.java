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

@Table(name="restaurant")
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public void changeNameAndAddress(String name,String address){
        this.name = name;
        this.address = address;
        this.updatedAt = ZonedDateTime.now();
    }
}
