package com.example.spring_mvn.repository;

import com.example.spring_mvn.dto.UserRoleModel;
import com.example.spring_mvn.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<Object> findByUsername(String username);

//    @Query("SELECT new com.example.spring_mvn.dto.UserAccessDTO(u.username, ua.accessId, ur.roleDetails) FROM User u JOIN u.useraccesses ua JOIN UserRole ur ON ur.id=ua.accessId")
//    public List<RoleModel> getUserAccess();

    @Query("SELECT new com.example.spring_mvn.dto.UserRoleModel(u.id,ur.roleId, u.username, r.roleName)" +
            " FROM User u JOIN UserRole ur ON ur.userId=u.id JOIN Roles r ON r.id = ur.roleId WHERE u.username= :username")
    UserRoleModel getUserRole(@Param("username") String username);
}
