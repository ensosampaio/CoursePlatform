package com.enzo.courseplatform.repository;

import com.enzo.courseplatform.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
