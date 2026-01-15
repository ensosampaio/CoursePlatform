package com.enzo.courseplatform.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateEnrollmentRequest(
        @NotNull(message = "Course id is required") Integer courseId
){
}
