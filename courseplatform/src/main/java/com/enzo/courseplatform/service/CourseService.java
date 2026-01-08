package com.enzo.courseplatform.service;

import com.enzo.courseplatform.repository.CourseRepository;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }



}
