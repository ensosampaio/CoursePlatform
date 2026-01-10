package com.enzo.courseplatform.dto.response;

public record LoginResponse(
        Integer id,
        String name,
        String email,
        String role
) {
}
