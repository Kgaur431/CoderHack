package com.example.coderhack.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashSet;
import java.util.Set;


@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String username;
    private int score;
    private Set<Badge> badges;

    // No-argument constructor (required for MongoDB deserialization) for get all the users
    public User() {
    }

    // Constructors
    public User(String username, int score) {
        this.username = username;
        this.score =  score;
        this.badges = new HashSet<>();
    }

    public User(String username) {
        this.username = username;
        this.score =  0;
        this.badges = new HashSet<>();
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String userId, String username, int score, Set<Badge> badges) {
        this.userId = userId;
        this.username = username;
        this.score = score;
        this.badges = badges != null ? badges : new HashSet<>();            // null safety
    }

    public void addBadge(Badge badge) {
        if (badges.size() < 3) {  // Ensures no more than 3 badges
            badges.add(badge);
        }
    }

    public void awardBadges() {
        if (score >= 60 && !badges.contains(Badge.CODE_MASTER)) {
            badges.add(Badge.CODE_MASTER);
        } else if (score >= 30 && !badges.contains(Badge.CODE_CHAMP)) {
            badges.add(Badge.CODE_CHAMP);
        } else if (score > 0 && !badges.contains(Badge.CODE_NINJA)) {
            badges.add(Badge.CODE_NINJA);
        }
    }

    public Set<Badge> getBadges() {
        return badges;
    }

    public int getScore() {
        return score;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
