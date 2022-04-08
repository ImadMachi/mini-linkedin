package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.UserDao;
import com.example.minilinkedin.service.facade.CompetenceService;
import com.example.minilinkedin.service.facade.ReponseAnnonceService;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private int validate(User user) {
        if (user.getLogin() == null) return -1;
        else if (user.getCompetences() == null || user.getCompetences().isEmpty()) return -2;
        else if (user.getReponseAnnonces() == null || user.getReponseAnnonces().isEmpty()) return -3;
        else return 1;
    }

    private void hundleProcess(User user) {
        userDao.save(user);
        saveCompetences(user);
        saveReponseAnonces(user);

    }

    private void saveCompetences(User user) {
        for (Competence c : user.getCompetences()) {
            c.setUser(user);
            competenceService.save(c);
        }
    }

    private void saveReponseAnonces(User user) {
        for (ReponseAnnonce rep : user.getReponseAnnonces()) {
            rep.setUser(user);
            reponseAnnonceService.save(rep);
        }
    }

    public int exec(User user) {
        int res = validate(user);
        if (res > 0) hundleProcess(user);
        return res;
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Transactional
    public int deleteByLogin(String login) {
        User user = userDao.findByLogin(login);
        if (user == null) {
            return -1;
        } else {
            user.getReponseAnnonces().forEach(e -> reponseAnnonceService.deleteByUserLogin(e.getUser().getLogin()));
            user.getCompetences().forEach(e -> competenceService.deleteByUserLogin(e.getUser().getLogin()));
            userDao.deleteByLogin(login);
            return 1;
        }
    }

    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private ReponseAnnonceService reponseAnnonceService;
    @Autowired
    private UserDao userDao;
}
