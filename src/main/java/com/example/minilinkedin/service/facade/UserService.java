package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByLogin(String login);

    User loadUserByUsername(String username);
   
    int deleteByLogin(String login);

    void update(User user);

    int exec(User user);

    String signIn(User user);
}
