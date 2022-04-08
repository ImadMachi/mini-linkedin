package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.dao.ReponseAnnonceDao;
import com.example.minilinkedin.service.facade.ReponseAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseAnnonceServiceImpl implements ReponseAnnonceService {

    @Autowired
    private ReponseAnnonceDao reponseAnnonceDao;
}
