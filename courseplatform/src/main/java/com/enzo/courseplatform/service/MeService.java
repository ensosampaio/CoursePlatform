package com.enzo.courseplatform.service;

import com.enzo.courseplatform.config.SecurityUtils;
import com.enzo.courseplatform.dto.response.EnrollmentResponseDTO;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.exception.ResourceNotFoundException;
import com.enzo.courseplatform.model.User;
import com.enzo.courseplatform.repository.EnrollmentRepository;
import com.enzo.courseplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeService {
    private final UserRepository userRepository;
    private final EnrollmentRepository enrollmentRepository;

    public MeService(UserRepository userRepository, EnrollmentRepository enrollmentRepository) {
        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public UserResponseDTO getProfile(){
        String email = SecurityUtils.getAuthenticatedEmail();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return UserResponseDTO.fromEntity(user);
    }

    public List<EnrollmentResponseDTO> getMyEnrollments(){
        String email = SecurityUtils.getAuthenticatedEmail();
        User user = userRepository.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return enrollmentRepository.findByUserId(user.getId()).stream().map(EnrollmentResponseDTO::fromEntity).toList();
    }

}
