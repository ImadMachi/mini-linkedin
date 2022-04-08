package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.dao.ReponseAnnonceDao;
import com.example.minilinkedin.service.facade.ReponseAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReponseAnnonceServiceImpl implements ReponseAnnonceService {

    public int save(ReponseAnnonce reponseAnnonce) {
        reponseAnnonceDao.save(reponseAnnonce);
        return 1;
    }
    public List<ReponseAnnonce> findByUserLogin(String login){
        return reponseAnnonceDao.findByUserLogin(login);
    }
    public int deleteByUserLogin(String login) {
        return reponseAnnonceDao.deleteByUserLogin(login);
    }
    @Autowired
    private ReponseAnnonceDao reponseAnnonceDao;

}