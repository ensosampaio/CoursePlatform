package com.enzo.courseplatform.repository;

import com.enzo.courseplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
