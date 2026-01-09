package com.enzo.courseplatform.controller;

import com.enzo.courseplatform.dto.request.CreateEnrollmentRequest;
import com.enzo.courseplatform.dto.response.EnrollmentResponseDTO;
import com.enzo.courseplatform.model.Enrollment;
import com.enzo.courseplatform.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/courses/{courseId}")
    public List<EnrollmentResponseDTO> findByCourseId(@PathVariable Integer courseId) {
       return enrollmentService.getByCourse(courseId);
    }
    @GetMapping("/users/{userId}")
    public List<EnrollmentResponseDTO> findByUserId(@PathVariable Integer userId) {
        return enrollmentService.getByUser(userId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResponseDTO enroll(@RequestBody @Valid CreateEnrollmentRequest request){
        return enrollmentService.enroll(request);
    }


}
