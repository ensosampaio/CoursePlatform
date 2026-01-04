package com.enzo.courseplatform.Repository;

import com.enzo.courseplatform.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
