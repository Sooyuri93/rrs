package com.jyujyu.review.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "test")
@Getter
public class TestEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;


    public TestEntity() {

    }

    public TestEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void changeNameAndAge(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}
