package com.example.spring_mvn.repository;

import com.example.spring_mvn.entity.User_Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccessRepository extends JpaRepository<User_Access, Integer> {
}