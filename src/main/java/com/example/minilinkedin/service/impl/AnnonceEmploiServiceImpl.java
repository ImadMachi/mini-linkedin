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
    int deleteAnnonce(AnnonceEmploi annonceEmploi){
        AnnonceEmploi annonce = annonceEmploiDao.findByRef(annonceEmploi.getRef());
        if (annonce == null){
            return -1;
        }else{
            annonceEmploiDao.deleteByRef(annonceEmploi.getRef());
            return 1;
        }
    }

    int sauvgarder(AnnonceEmploi annonceEmploi){
        AnnonceEmploi annonce =annonceEmploiDao.findByRef(annonceEmploi.getRef());
        if (annonce !=null){
            return -1;
        }else{
            annonceEmploiDao.save(annonce);
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
