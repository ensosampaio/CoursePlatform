package com.enzo.courseplatform.service;

import com.enzo.courseplatform.dto.request.CreateEnrollmentRequest;
import com.enzo.courseplatform.dto.response.EnrollmentResponseDTO;
import com.enzo.courseplatform.exception.ResourceNotFoundException;
import com.enzo.courseplatform.model.Course;
import com.enzo.courseplatform.model.Enrollment;
import com.enzo.courseplatform.model.User;
import com.enzo.courseplatform.repository.CourseRepository;
import com.enzo.courseplatform.repository.EnrollmentRepository;
import com.enzo.courseplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, UserRepository userRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public EnrollmentResponseDTO enroll(CreateEnrollmentRequest request){
        if(enrollmentRepository.existsByUserIdAndCourseId(request.userId(),  request.courseId()))
        {
            throw new ResourceNotFoundException("User already enrolled in this course");
        }
        User user = userRepository.findById(request.userId()).orElseThrow(()->new ResourceNotFoundException("User not found"));
        Course course = courseRepository.findById(request.courseId()).orElseThrow(()->new ResourceNotFoundException("Course not found"));
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(LocalDateTime.now());

       Enrollment saved = enrollmentRepository.save(enrollment);
       return EnrollmentResponseDTO.fromEntity(saved);
    }
    public List<EnrollmentResponseDTO> getByUser(Integer userId){
        return enrollmentRepository.findByUserId(userId).stream().map(EnrollmentResponseDTO::fromEntity).toList();
    }

    public List<EnrollmentResponseDTO> getByCourse(Integer courseId){
        return enrollmentRepository.findByCourseId(courseId).stream().map(EnrollmentResponseDTO::fromEntity).toList();
    }


}
