package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.dao.AnnonceEmploiDao;
import com.example.minilinkedin.service.facade.AnnonceEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnonceEmploiServiceImpl implements AnnonceEmploiService {

    @Transactional
    int deleteAnnonce(String ref){
        AnnonceEmploi annonce = annonceEmploiDao.findByRef(ref);
        if (annonce == null){
            return -1;
        }else{
            annonceEmploiDao.deleteByRef(ref);
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
    AnnonceEmploiDao annonceEmploiDao;
}
