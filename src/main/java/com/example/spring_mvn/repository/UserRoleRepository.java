package com.example.spring_mvn.repository;

import com.example.spring_mvn.entity.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<User_Role, Integer> {
}
