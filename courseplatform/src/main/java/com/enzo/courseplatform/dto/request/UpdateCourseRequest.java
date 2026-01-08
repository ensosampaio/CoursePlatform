package com.enzo.courseplatform.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCourseRequest(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        @Min(1)
        Integer workloadHours,
        @NotNull
        Boolean active
) {
}
