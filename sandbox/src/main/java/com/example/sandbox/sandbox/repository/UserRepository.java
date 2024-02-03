package com.example.sandbox.sandbox.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sandbox.sandbox.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}