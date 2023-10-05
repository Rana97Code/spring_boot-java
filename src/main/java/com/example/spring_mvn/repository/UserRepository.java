package com.example.spring_mvn.repository;

import com.example.spring_mvn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
