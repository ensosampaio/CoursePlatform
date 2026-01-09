package com.enzo.courseplatform.repository;

import com.enzo.courseplatform.model.Course;
import com.enzo.courseplatform.model.Enrollment;
import com.enzo.courseplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    boolean existsByUserIdAndCourseId(Integer userId, Integer courseId);
    List<Enrollment> findByCourseId(Integer courseId);
    List<Enrollment>findByUserId(Integer userId);
}
