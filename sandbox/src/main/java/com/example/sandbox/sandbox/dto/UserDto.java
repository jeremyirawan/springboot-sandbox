package com.example.sandbox.sandbox.dto;

import java.util.Date;
import java.util.UUID;

import com.example.sandbox.sandbox.model.User.Gender;

public class UserDto {
    private UUID userId;
    private String fullname;
    private Date dateOfBirth;
    private Gender gender;
    private Date createdAt;
    private Date updatedAt;


    // Private constructor to enforce use of the Builder
    private UserDto(Builder builder) {
        this.userId = builder.userId;
        this.fullname = builder.fullname;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    // Getters (no setters to maintain immutability)
    public UUID getUserId() {
        return userId;
    }

    public String getFullname() {
        return fullname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Static Builder class
    public static class Builder {
        private UUID userId;
        private String fullname;
        private Date dateOfBirth;
        private Gender gender;
        private Date createdAt;
        private Date updatedAt;

        public Builder() {
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}