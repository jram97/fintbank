package com.fintbank.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fintbank.app.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
