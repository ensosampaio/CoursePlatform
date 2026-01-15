package com.enzo.courseplatform.controller;


import com.enzo.courseplatform.dto.response.EnrollmentResponseDTO;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.service.MeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/me")
@CrossOrigin
public class MeController {

    private final MeService meService;
    public MeController(MeService meService) {
        this.meService = meService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public UserResponseDTO me(){
        return meService.getProfile();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/enrollments")
    public List<EnrollmentResponseDTO> enrollments(){
        return meService.getMyEnrollments();
    }


}
