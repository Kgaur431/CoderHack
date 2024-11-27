package com.example.coderhack.service;



import com.example.coderhack.Exception.InvalidScoreException;
import com.example.coderhack.Util.UserMapper;
import com.example.coderhack.dto.UserResponseDTO;
import com.example.coderhack.entity.*;
import com.example.coderhack.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private final IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;      // Spring directly injects the dependency into the field, so there's no need to include it in the constructor.

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // Register a new user
    public ResponseEntity<String> registerUser(User user) {
        userRepository.save(user);
        return ResponseEntity.status(201).body("User registered successfully!");
    }

    // Update score for an existing user
    public ResponseEntity<String> updateUserScore(String userId, int score) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (!existingUser.isPresent()) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }

        if (score < 0 || score > 100) {
            throw new InvalidScoreException("Score must be between 0 and 100!");
        }

        User user = existingUser.get();
        user.setScore(score);
        user.awardBadges();  // Award badges based on score

        userRepository.save(user);
        return new ResponseEntity<>("User score updated successfully!", HttpStatus.OK);
    }

    // Get all users, sorted by score
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userRepository.findAllByOrderByScoreDesc();
        List<UserResponseDTO> userResponseDtos = users.stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(userResponseDtos, HttpStatus.OK);
    }

    // Get a specific user by userId
    public ResponseEntity<UserResponseDTO> getUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);          // from mongodb we are getting the user as optional type.

        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UserResponseDTO userResponseDTO = userMapper.toResponseDto(user.get());
        return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
    }

    // Delete a user
    public ResponseEntity<String> deleteUser(String userId) {
        if (!userRepository.existsById(userId)) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(userId);
        return new ResponseEntity<>("User deleted successfully!", HttpStatus.OK);
    }

}

