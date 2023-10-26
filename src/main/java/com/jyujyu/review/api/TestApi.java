package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {

    @GetMapping("/hello/world")
    public String helloWorld(){
        return "[Get] hello, world!";
    }

    @PostMapping("/hello/world")
    public String postHelloWorld(){
        return "[Post] hello, world!";
    }

    @PutMapping("/hello/world")
    public String putHelloWolrd(){
        return "[Put] hello, world!";
    }

    @DeleteMapping("/hello/world")
    public String deleteHelloWorld(){
        return "[Delete] hello, world!";
    }
}
