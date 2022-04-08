package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
    int deleteByLogin(String login);

}
