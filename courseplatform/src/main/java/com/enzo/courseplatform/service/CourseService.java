package com.enzo.courseplatform.service;

import com.enzo.courseplatform.dto.request.CreateCourseRequest;
import com.enzo.courseplatform.dto.request.UpdateCourseRequest;
import com.enzo.courseplatform.dto.response.CourseResponseDTO;
import com.enzo.courseplatform.exception.ResourceNotFoundException;
import com.enzo.courseplatform.model.Course;
import com.enzo.courseplatform.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void createCourse(CreateCourseRequest request){
        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setWorkloadHours(request.getWorkloadHours());
        courseRepository.save(course);
    }

    public CourseResponseDTO getById(Integer id){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return CourseResponseDTO.fromEntity(course);
    }

    public List<CourseResponseDTO> getAll(){
        return  courseRepository.findAll().stream().map(CourseResponseDTO::fromEntity).toList();
    }

    public void updateUser(Integer id, UpdateCourseRequest request){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        course.setTitle(request.title());
        course.setDescription(request.description());
        course.setWorkloadHours(request.workloadHours());
        course.setActive(request.active());
        courseRepository.save(course);

    }

}
