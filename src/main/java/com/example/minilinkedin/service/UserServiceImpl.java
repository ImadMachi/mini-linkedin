package com.example.minilinkedin.service;

import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.UserDao;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Transactional
    public int deleteByLogin(String login){
        User user = userDao.findByLogin(login);
        if(user == null) {
            return -1;
        } else {
            userDao.deleteByLogin(login);
            return 1;
        }
    }

    @Autowired
    private UserDao userDao;
}
