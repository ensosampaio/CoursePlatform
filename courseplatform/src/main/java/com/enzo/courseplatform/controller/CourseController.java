package com.enzo.courseplatform.controller;


import com.enzo.courseplatform.dto.request.CreateCourseRequest;
import com.enzo.courseplatform.dto.request.UpdateCourseRequest;
import com.enzo.courseplatform.dto.response.CourseResponseDTO;
import com.enzo.courseplatform.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponseDTO> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public CourseResponseDTO getById(@PathVariable Integer id){
        return courseService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCourse(@RequestBody @Valid CreateCourseRequest request){
        courseService.createCourse(request);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@PathVariable Integer id, @RequestBody @Valid UpdateCourseRequest request){
        courseService.updateUser(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
