package com.enzo.courseplatform.service;

import com.enzo.courseplatform.dto.request.CreateUsersRequest;
import com.enzo.courseplatform.dto.response.UserResponseDTO;
import com.enzo.courseplatform.model.User;
import com.enzo.courseplatform.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

}
