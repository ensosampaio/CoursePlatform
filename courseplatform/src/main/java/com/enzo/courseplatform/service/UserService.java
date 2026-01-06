package com.enzo.courseplatform.service;

import com.enzo.courseplatform.dto.request.CreateUsersRequest;
import com.enzo.courseplatform.dto.request.UpdateUserRequest;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.exception.ResourceNotFoundException;
import com.enzo.courseplatform.model.User;
import com.enzo.courseplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(CreateUsersRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        userRepository.save(user);
    }

    public UserResponseDTO getUserById(Integer id){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }


    public List<UserResponseDTO> getAllUsers() {
       return userRepository.findAll().stream().map(UserResponseDTO::fromEntity).toList();
    }

    public void updateUser(Integer id, UpdateUserRequest updateUserRequest){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setName(updateUserRequest.name());
        user.setEmail(updateUserRequest.email());
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }

}
