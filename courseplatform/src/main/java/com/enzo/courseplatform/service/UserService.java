package com.enzo.courseplatform.service;

import com.enzo.courseplatform.dto.request.CreateUserRequest;
import com.enzo.courseplatform.dto.request.UpdateUserRequest;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.exception.ResourceNotFoundException;
import com.enzo.courseplatform.model.Role;
import com.enzo.courseplatform.model.User;
import com.enzo.courseplatform.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserResponseDTO createUser(CreateUserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(Role.USER);

        User saved = userRepository.save(user);
        return UserResponseDTO.fromEntity(saved);
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
