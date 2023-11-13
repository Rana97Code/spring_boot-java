package com.example.spring_mvn.repository;

import com.example.spring_mvn.dto.UserAccessDTO;
import com.example.spring_mvn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<Object> findByUsername(String username);

//    @Query("SELECT new com.example.spring_mvn.dto.UserAccessDTO(u.name, ua.accessId, ur.roleDetails) FROM User u JOIN u.useraccesses ua JOIN User_Role ur ON ur.id=ua.accessId")
//    public List<UserAccessDTO> getUserAccess();
}
