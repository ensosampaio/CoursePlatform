package com.enzo.courseplatform.repository;

import com.enzo.courseplatform.model.Course;
import com.enzo.courseplatform.model.Enrollment;
import com.enzo.courseplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    boolean existsByUserAndCourse(User user, Course course);
}
