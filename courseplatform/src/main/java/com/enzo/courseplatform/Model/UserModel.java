package com.enzo.courseplatform.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;

@Entity

public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime createdAt = LocalDateTime.now();
}
