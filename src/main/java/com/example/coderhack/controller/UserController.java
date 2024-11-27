package com.example.coderhack.controller;



import com.example.coderhack.dto.*;
import com.example.coderhack.entity.User;
import com.example.coderhack.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequestDTO userRequestDto) {
        User user = new User(userRequestDto.getUsername());
        return userService.registerUser(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUserScore(@PathVariable String userId, @RequestParam int score) {
        return userService.updateUserScore(userId, score);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return userService.getAllUsers();
    }

    // Endpoint to fetch user details by ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    // Endpoint to delete a user
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}


/**
 * writ e the postman collection
 *      - register a user
 *          http://localhost:8080/api/users/register
 *          {
 *          "username": "JohnDoe",
 *          "score": 80
 *          }
 *          - response: User registered successfully!'
 *          - status: 201 Created
 *          - headers: Content-Type: application/json
 *          - body: User registered successfully!
 *
 *      - update user score
 *            http://localhost:8080/api/users/1/score?score=90
 *            - response: User score updated successfully!
 *            - status: 200 OK
 *      -  get all users
 *      http://localhost:8080/api/users
 *      - response: [
 *      {
 *      "userId": "1",
 *      "username": "JohnDoe",
 *      "score": 90,
 *      "badges": [
 *      "CODE_MASTER"
 *      ]
 *      }
 *      ]
 *      - status: 200 OK
 *
 *   - get user by id
 *   http://localhost:8080/api/users/1
 *      - response: {
 *      "userId": "1",
 *      "username": "JohnDoe",
 *      "score": 90,
 *      "badges": [
 *      "CODE_MASTER"
 *      ]
 *      }
 *          - status: 200 OK
 *
 *   -  delete user
 *          http
 *
 *
 *
 *
 *
 *
 *
 */