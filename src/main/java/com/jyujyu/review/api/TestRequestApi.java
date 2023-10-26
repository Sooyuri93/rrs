package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {
    // Request Parameter
    @GetMapping("/test/param")
    public String requestParam(
            @RequestParam("name") String name,
            @RequestParam("age") String age
    ){
        return "Hello, Request Param, I am "+ name +", " + age;
    }

    // path Variable
    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") String age
    ){
        return "Hello, Request Param, I am "+ name +", " + age;
    }

    //request Body
    @PostMapping("/test/body")
    public String requestBody(
            @RequestBody TestRequestBody requestBody
    ){
        return "Hello, Request body" + requestBody.name + ","+ requestBody.age;
    }

    public static class TestRequestBody{
        String name;
        Integer age;

        public TestRequestBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
