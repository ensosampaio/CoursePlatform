package com.enzo.courseplatform.Repository;

import com.enzo.courseplatform.Model.Course;
import com.enzo.courseplatform.Model.Enrollment;
import com.enzo.courseplatform.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    boolean existsByUserAndCourse(User user, Course course);
}
