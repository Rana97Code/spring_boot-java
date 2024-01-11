package com.vat.bmitvat.repository;

import com.vat.bmitvat.entity.UserPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionRepository extends JpaRepository<UserPermissionEntity,Long> {
}
