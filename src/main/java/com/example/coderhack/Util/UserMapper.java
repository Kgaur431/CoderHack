package com.example.coderhack.Util;

import com.example.coderhack.dto.UserResponseDTO;
import com.example.coderhack.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDTO toResponseDto(User user) {
        return new UserResponseDTO(
                user.getUserId(),
                user.getUsername(),
                user.getScore(),
                user.getBadges()
        );
    }
}
