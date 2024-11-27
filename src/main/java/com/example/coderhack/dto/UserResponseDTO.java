package com.example.coderhack.dto;

import com.example.coderhack.entity.Badge;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO {

    private String userId;
    private String username;
    private int score;
    private Set<Badge> badges;

    // Constructors, Getters, and Setters
    public UserResponseDTO(String userId, String username, int score, Set<Badge> badges) {
        this.userId = userId;
        this.username = username;
        this.score = score;
        this.badges = badges;
    }

}
