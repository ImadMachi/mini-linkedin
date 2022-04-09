package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.AnnonceEmploiDao;
import com.example.minilinkedin.service.facade.AnnonceEmploiService;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceEmploiServiceImpl implements AnnonceEmploiService {

    public List<AnnonceEmploi> findAnnonceEmploisByLogin(String loginUser) {
        List<AnnonceEmploi> annonceEmplois = new ArrayList<AnnonceEmploi>();
        AnnonceEmploi annonceEmploi;
        User user = userService.findByLogin(loginUser);
        for (ReponseAnnonce reponseAnnonce : user.getReponseAnnonces()) {
            annonceEmploi = reponseAnnonce.getAnnonceEmploi();
            annonceEmplois.add(annonceEmploi);
        }
        return annonceEmplois;
    }

    @Transactional
    public int deleteAnnonce(String ref) {
        AnnonceEmploi annonce = annonceEmploiDao.findByRef(ref);
        if (annonce == null) {
            return -1;
        } else {
            annonceEmploiDao.deleteByRef(ref);
            return 1;
        }
    }

    public int sauvgarder(AnnonceEmploi annonceEmploi) {
        AnnonceEmploi annonce = annonceEmploiDao.findByRef(annonceEmploi.getRef());
        if (annonce != null) {
            return -1;
        } else {
            annonceEmploiDao.save(annonceEmploi);
            return 1;
        }
    }

    public AnnonceEmploi findByRef(String ref) {
        return annonceEmploiDao.findByRef(ref);
    }


    public int deleteByRef(String ref) {
        return annonceEmploiDao.deleteByRef(ref);
    }

    @Autowired
    UserService userService;
    @Autowired
    AnnonceEmploiDao annonceEmploiDao;
}
