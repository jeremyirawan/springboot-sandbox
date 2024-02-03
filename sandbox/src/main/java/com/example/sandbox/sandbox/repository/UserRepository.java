package com.example.sandbox.sandbox.repository;

import com.example.sandbox.sandbox.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
