package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApo {
    @GetMapping("/test/response/string")
    public String stringResponse(){
        return "this is string";
    }

    @GetMapping("/test/response/json")
    public TestResponseBody jsonResponse(){
        return new TestResponseBody("sooyeol",31);
    }

    public static class TestResponseBody{
        String name;
        Integer age;

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
