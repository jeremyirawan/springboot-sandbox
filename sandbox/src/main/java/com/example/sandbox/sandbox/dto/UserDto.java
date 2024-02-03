package com.example.sandbox.sandbox.dto;

import com.example.sandbox.sandbox.model.User.Gender;
import java.util.Date;
import java.util.UUID;

public class UserDto {
    private UUID userId;
    private String fullname;
    private Date dateOfBirth;
    private Gender gender;
    private Date createdAt;
    private Date updatedAt;
}
