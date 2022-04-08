package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.dao.CompetenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceServiceImpl {
    @Autowired
   private CompetenceDao competenceDao;

    public int save(Competence competence){
        //User user =UserService.
        if (competenceDao.findByLibelle(competence.getLibelle())!= null){
            return -1;
        }else
        return 1;
    }
}
