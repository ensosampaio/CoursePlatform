package com.enzo.courseplatform.Repository;

import com.enzo.courseplatform.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
