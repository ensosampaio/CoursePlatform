package com.enzo.courseplatform.dto.request;

import jakarta.validation.constraints.NotNull;

public class CreateEnrollmentRequest {

    @NotNull(message = "User id is required")
    private Integer userId;

    @NotNull(message = "Course id is required")
    private Integer courseId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
