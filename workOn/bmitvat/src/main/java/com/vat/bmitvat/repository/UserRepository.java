package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.UserEntity;
import com.vat.bmitvat.model.TokenModel;
import com.vat.bmitvat.model.UserAccessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<Object> findByUsername(String username);

//    @Query("SELECT new com.vat.bmitvat.model.UserAccessModel(u.name, ua.accessId, ur.roleDetails)" +
//            " FROM User u JOIN u.useraccesses ua JOIN User_Role ur ON ur.id=ua.accessId")
//    public List<UserAccessModel> getUserAccess();

//    @Query("SELECT new com.example.spring_mvn.dto.UserRoleModel(u.id,ur.roleId, u.username, r.roleName)" +
//            " FROM User u JOIN UserRole ur ON ur.userId=u.id JOIN Roles r ON r.id = ur.roleId WHERE u.username= :username")
    @Query("SELECT new com.vat.bmitvat.model.TokenModel(u.id, u.username, u.userEmail, u.userPhone, u.userNid, u.nidScan, u.profileImage, u.userType)" +
            " FROM UserEntity u WHERE u.username= :username")
    TokenModel getUserDetails(@Param("username") String username);
}