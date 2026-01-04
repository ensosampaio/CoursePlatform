package com.enzo.courseplatform.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCourseRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull(message = "Workload hours is required")
    @Min(value=1, message = "Workload must be at least 1 hour")
    private Integer workloadHours;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWorkloadHours() {
        return workloadHours;
    }

    public void setWorkloadHours(Integer workloadHours) {
        this.workloadHours = workloadHours;
    }
}
