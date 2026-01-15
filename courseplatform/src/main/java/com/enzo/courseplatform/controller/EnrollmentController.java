package com.enzo.courseplatform.controller;

import com.enzo.courseplatform.dto.request.CreateEnrollmentRequest;
import com.enzo.courseplatform.dto.response.EnrollmentResponseDTO;
import com.enzo.courseplatform.model.Enrollment;
import com.enzo.courseplatform.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/courses/{courseId}")
    public List<EnrollmentResponseDTO> findByCourseId(@PathVariable Integer courseId) {
       return enrollmentService.getByCourse(courseId);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/users/{userId}")
    public List<EnrollmentResponseDTO> findByUserId(@PathVariable Integer userId) {
        return enrollmentService.getByUser(userId);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void enroll(@RequestBody @Valid CreateEnrollmentRequest request){
        enrollmentService.enroll(request);
    }


}
