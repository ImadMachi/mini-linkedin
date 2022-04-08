package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.UserDao;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   int validate(User user){
if (user.getLogin()==null)return -1;
else if (user.getCompetences()==null||user.getCompetences().isEmpty())return -2;
else if (user.getReponseAnnonces()==null||user.getReponseAnnonces().isEmpty())return -3;
else return 1;
    }
    
    public int save(User user) {
        User existingUser = userDao.findByLogin(user.getLogin());
        if(existingUser != null) {
            return -1;
        } else {
            userDao.save(user);
            return 1;
        }
    }

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

    @Autowired
    private ReponseAnnonceServiceImpl reponseAnnonceServiceImpl;
}
