package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
}
