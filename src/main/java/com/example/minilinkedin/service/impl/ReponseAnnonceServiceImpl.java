package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.ReponseAnnonceDao;
import com.example.minilinkedin.service.facade.AnnonceEmploiService;
import com.example.minilinkedin.service.facade.ReponseAnnonceService;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReponseAnnonceServiceImpl implements ReponseAnnonceService {
    void prepare(ReponseAnnonce reponseAnnonce) {
        User user = userService.findByLogin(reponseAnnonce.getUser().getLogin());
        reponseAnnonce.setUser(user);
        AnnonceEmploi annonceEmploi = annonceEmploiService.findByRef(reponseAnnonce.getAnnonceEmploi().getRef());
        reponseAnnonce.setAnnonceEmploi(annonceEmploi);
    }

    private int validate(ReponseAnnonce reponseAnnonce) {
        if (reponseAnnonceDao.findByRef(reponseAnnonce.getRef()) != null) return -1;
        else if (reponseAnnonce.getUser() == null) return -2;
        else if (reponseAnnonce.getAnnonceEmploi() == null) return -3;
        else return 1;
    }

    void handleProcess(ReponseAnnonce reponseAnnonce) {
        reponseAnnonceDao.save(reponseAnnonce);
        User user = reponseAnnonce.getUser();
        List<ReponseAnnonce> reponseAnnonces = user.getReponseAnnonces();
        reponseAnnonces.add(reponseAnnonce);
        user.setReponseAnnonces(reponseAnnonces);
        userService.update(user);
    }


    public int exec(ReponseAnnonce reponseAnnonce) {
        prepare(reponseAnnonce);
        int res = validate(reponseAnnonce);
        if (res > 0) {
            handleProcess(reponseAnnonce);
        }
        return res;
    }


    public List<ReponseAnnonce> findByUserLogin(String login) {
        return reponseAnnonceDao.findByUserLogin(login);
    }

    public int deleteByUserLogin(String login) {
        return reponseAnnonceDao.deleteByUserLogin(login);
    }

    public ReponseAnnonce findByRef(String ref) {
        return reponseAnnonceDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return reponseAnnonceDao.deleteByRef(ref);
    }

    @Autowired
    private AnnonceEmploiService annonceEmploiService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReponseAnnonceDao reponseAnnonceDao;

}