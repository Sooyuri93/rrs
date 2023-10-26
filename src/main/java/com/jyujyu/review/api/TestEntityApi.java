package com.jyujyu.review.api;

import com.jyujyu.review.service.TestService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TestEntityApi {

    private final TestService service;

    @GetMapping("/test/entity/create")
    public void createTestEntity(){
        service.create("sooyeol",31);
    }

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTesstEntityRequest request
    ){
        service.create(request.getName(), request.age);
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/test/entity/{id}")
    public void updateTestEntity(
            @PathVariable Long id,
            @RequestBody CreateTesstEntityRequest createTesstEntityRequest
    ){
        service.update(id, createTesstEntityRequest.name,createTesstEntityRequest.age);
    }

    @AllArgsConstructor
    @Getter
    public static class CreateTesstEntityRequest{
        private final String name;
        private final Integer age;
    }
}
