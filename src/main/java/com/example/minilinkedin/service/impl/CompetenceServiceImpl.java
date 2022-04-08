package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.CompetenceDao;
import com.example.minilinkedin.service.facade.CompetenceService;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServiceImpl implements CompetenceService {
    @Autowired
    private CompetenceDao competenceDao;
    @Autowired
    private UserService userService;
// save competence
    public int save(Competence competence) {
        User user = userService.findByLogin(competence.getUser().getLogin());
        competence.setUser(user);
        if (competenceDao.findByLibelle(competence.getLibelle()) != null) {
            return -1;
        }
        else if (user == null) {
            return -2;
        }
        else {
            competenceDao.save(competence);
            return 1;
        }
    }

// findBy libelle
    public Competence findByLibelle(String libelle) {
        return competenceDao.findByLibelle(libelle);
    }

// deleteBy lebelle
    public int deleteByLibelle(String libelle) {
         return competenceDao.deleteByLibelle(libelle);
    }
//     find liste competence
    public List<Competence> findByUserLogin(String login) {
        return competenceDao.findByUserLogin(login);
    }
// delete liste competence
    public int deleteByUserLogin(String login) {
        return competenceDao.deleteByUserLogin(login);
    }
}
