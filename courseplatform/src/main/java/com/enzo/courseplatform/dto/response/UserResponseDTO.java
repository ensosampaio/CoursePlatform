package com.enzo.courseplatform.dto.response;

import com.enzo.courseplatform.model.User;

public record UserResponseDTO(
        Integer id,
        String name,
        String email
) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}