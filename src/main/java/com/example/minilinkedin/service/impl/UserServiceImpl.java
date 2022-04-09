package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.UserDao;
import com.example.minilinkedin.service.facade.AnnonceEmploiService;
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
        else if (userDao.findByLogin(user.getLogin()) != null) return -2;
        else if (user.getCompetences() == null || user.getCompetences().isEmpty()) return -3;
//        else if (user.getReponseAnnonces() == null || user.getReponseAnnonces().isEmpty()) return -4;
        else return 1;
    }

    private void hundleProcess(User user) {
        userDao.save(user);
        saveCompetences(user);
//        saveReponseAnonces(user);
    }

    private void saveCompetences(User user) {
        for (Competence c : user.getCompetences()) {
            c.setUser(user);
            competenceService.saveCompetence(c);
        }
    }

//    private void saveReponseAnonces(User user) {
//        for (ReponseAnnonce rep : user.getReponseAnnonces()) {
//            rep.setUser(user);
//            saveAnonceEmploi(rep);
//            AnnonceEmploi annonceEmploi = annonceEmploiService.findByRef(rep.getAnnonceEmploi().getRef());
//            rep.setAnnonceEmploi(annonceEmploi);
//            reponseAnnonceService.save(rep);
//        }
//    }

//    public void saveAnonceEmploi(ReponseAnnonce reponseAnnonce) {
//        annonceEmploiService.sauvgarder(reponseAnnonce.getAnnonceEmploi());
//    }

    public int exec(User user) {
        int res = validate(user);
        if (res > 0) hundleProcess(user);
        return res;
    }

    public void update(User user) {
        if(userDao.findByLogin(user.getLogin()) != null) {
            userDao.save(user);
        }
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
            int res = 0;
            res += reponseAnnonceService.deleteByUserLogin(user.getLogin());
            res += competenceService.deleteByUserLogin(user.getLogin());
            res += userDao.deleteByLogin(login);
            return res;
        }
    }

    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private ReponseAnnonceService reponseAnnonceService;
    @Autowired
    AnnonceEmploiService annonceEmploiService;
    @Autowired
    private UserDao userDao;
}
