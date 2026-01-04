package com.enzo.courseplatform.Repository;

import com.enzo.courseplatform.Model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
