package com.jyujyu.review.service;

import com.jyujyu.review.repository.TestRepository;
import com.jyujyu.review.model.TestEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository repository;

    public void create(String name, Integer age){
        TestEntity entity = new TestEntity(name,age);
        repository.save(entity);

    }

    public void delete(Long id){
        TestEntity entity = repository.findById(id).get();
        repository.delete(entity);
    }

    public void update(Long id, String name, Integer age){
        TestEntity entity = repository.findById(id).orElseThrow();
        entity.changeNameAndAge(name,age);
        repository.save(entity);
    }

    public List<TestEntity> findAllByNameByJPA(String name){
        return repository.findAllByName(name);
    }

    public List<TestEntity> findAllByNameByQuerydsl(String name){
        return repository.findAllByNameByQuerydsl(name);
    }

}
