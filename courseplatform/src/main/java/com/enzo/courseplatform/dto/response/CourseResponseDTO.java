package com.enzo.courseplatform.dto.response;

import com.enzo.courseplatform.model.Course;

public record CourseResponseDTO(
        Integer id,
        String title,
        String description,
        Integer workloadHours,
        Boolean active
) {

    public static CourseResponseDTO fromEntity(Course course){
        return new CourseResponseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getWorkloadHours(),
                course.getActive()
        );
    }
}
