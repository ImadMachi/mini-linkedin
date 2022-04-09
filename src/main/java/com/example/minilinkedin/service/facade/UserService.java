package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.User;

public interface UserService {
    User findByLogin(String login);
   
    int deleteByLogin(String login);

    void update(User user);

    int exec(User user);
}
