package com.example.coderhack.repository;

import com.example.coderhack.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import  com.example.coderhack.repository.IUserRepository;
import java.util.List;

@Repository
public class UserRepository  {

//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Override
//    public List<User> findAllByOrderByScoreDesc() {
//        // Custom query to find users sorted by their score in descending order
//        return mongoTemplate.findAll(User.class).stream()
//                .sorted((u1, u2) -> Integer.compare(u2.getScore(), u1.getScore())) // Sorting in descending order by score
//                .toList(); // Collect the sorted list
//
//    }

}