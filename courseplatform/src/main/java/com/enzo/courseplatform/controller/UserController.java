package com.enzo.courseplatform.controller;

import com.enzo.courseplatform.dto.request.CreateUsersRequest;
import com.enzo.courseplatform.dto.request.UpdateUserRequest;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getALl(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid CreateUsersRequest request){
        userService.createUser(request);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Integer id, @RequestBody @Valid UpdateUserRequest request){
        userService.updateUser(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }




}
