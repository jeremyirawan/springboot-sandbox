package com.example.sandbox.sandbox.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class User {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID userId;

    private String fullname;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public enum Gender {
        MALE,
        FEMALE,
        NOT_SPECIFIED
    }

     // Private constructor that takes a Builder object
     private User(Builder builder) {
        this.userId = builder.userId;
        this.fullname = builder.fullname;
        this.dateOfBirth = builder.dateOfBirth;
        this.gender = builder.gender;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }
    
    // Getters for all fields
    public UUID userId() {
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

        public Builder withId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder withFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder withDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder withCreatedAt(Date createdAt) { 
            this.createdAt = createdAt;
            return this;
        }

        public Builder withUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
