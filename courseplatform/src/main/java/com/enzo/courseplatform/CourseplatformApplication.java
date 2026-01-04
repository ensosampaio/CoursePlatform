package com.enzo.courseplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CourseplatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseplatformApplication.class, args);
    }

}
