package com.example.coderhack.repository;

import com.example.coderhack.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

// Repository interface for User entity
public interface IUserRepository extends MongoRepository<User, String>{
    List<User> findAllByOrderByScoreDesc();
    /**
     *
     * The method findAllByOrderByScoreDesc follows Spring Data's naming conventions.
     * Spring Data automatically parses the method name and generates the query to sort all users by their score field in descending order.
     */
}
