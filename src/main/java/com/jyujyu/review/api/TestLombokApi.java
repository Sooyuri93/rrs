package com.jyujyu.review.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLombokApi {

    @GetMapping("/test/lombok")
    public String testLombok(){
        return "lombok";
    }

    @GetMapping("/test/lombok2")
    public TestLombokResponseBody testLombokResponseBody(){
        return new TestLombokResponseBody("name",10);
    }

    @Data
    @AllArgsConstructor
    public static class TestLombokResponseBody{
        String name;
        Integer age;
    }
}
