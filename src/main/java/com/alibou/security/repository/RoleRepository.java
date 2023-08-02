package com.alibou.security.repository;

import com.alibou.security.model.Role;
import com.alibou.security.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleEnum name);
}
