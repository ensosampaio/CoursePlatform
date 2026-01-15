package com.enzo.courseplatform;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Key;

@SpringBootApplication
@RestController
public class CourseplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseplatformApplication.class, args);
    }

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }


}
