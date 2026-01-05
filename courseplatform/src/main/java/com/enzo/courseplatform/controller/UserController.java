package com.enzo.courseplatform.controller;

import com.enzo.courseplatform.dto.request.CreateUsersRequest;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    public void createUser(@RequestBody @Valid CreateUsersRequest request){
        userService.createUser(request);
    }

    public UserResponseDTO getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

}
