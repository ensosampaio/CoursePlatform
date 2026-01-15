package com.enzo.courseplatform.controller;


import com.enzo.courseplatform.dto.request.CreateCourseRequest;
import com.enzo.courseplatform.dto.request.UpdateCourseRequest;
import com.enzo.courseplatform.dto.response.CourseResponseDTO;
import com.enzo.courseplatform.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public Page<CourseResponseDTO> getAll(@RequestParam(defaultValue = "0") @Min(0) int page, @RequestParam(defaultValue = "10") @Min(1) int size){
        return courseService.getAll(page,size);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public CourseResponseDTO getById(@PathVariable Integer id){
        return courseService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponseDTO createCourse(@RequestBody @Valid CreateCourseRequest request){
       return courseService.createCourse(request);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@PathVariable Integer id, @RequestBody @Valid UpdateCourseRequest request){
        courseService.updateCourse(id,request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
