package com.enzo.courseplatform.dto.response;

import com.enzo.courseplatform.model.Enrollment;

import java.time.LocalDateTime;

public record EnrollmentResponseDTO(
        Integer id,
        Integer userId,
        String userName,
        Integer courseId,
        String courseTitle,
        LocalDateTime enrolledAt,
        Boolean active
) {
    public static EnrollmentResponseDTO fromEntity(Enrollment enrollment) {
        return new EnrollmentResponseDTO(
                enrollment.getId(),
                enrollment.getUser().getId(),
                enrollment.getUser().getName(),
                enrollment.getCourse().getId(),
                enrollment.getCourse().getTitle(),
                enrollment.getEnrolledAt(),
                enrollment.getActive()
        );
    }

}