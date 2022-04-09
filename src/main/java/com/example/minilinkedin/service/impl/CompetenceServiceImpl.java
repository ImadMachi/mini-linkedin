package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.CompetenceDao;
import com.example.minilinkedin.service.facade.CompetenceService;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenceServiceImpl implements CompetenceService {
    @Autowired
    private CompetenceDao competenceDao;
    @Autowired
    private UserService userService;

    // save competence
    private int validate(Competence competence) {
        if (competenceDao.findByLibelle(competence.getLibelle()) != null) return -1;
        else if (competence.getUser() == null) return -2;
        else {
            return 1;
        }
    }

    private void prepare(Competence competence) {
        User user = userService.findByLogin(competence.getUser().getLogin());
        competence.setUser(user);
    }

    // save competence
    public int saveCompetence(Competence competence) {
        prepare(competence);
        int res = validate(competence);
        if (res > 0) competenceDao.save(competence);
        return res;
    }

    // findBy libelle
    public Competence findByLibelle(String libelle) {
        return competenceDao.findByLibelle(libelle);
    }

    // deleteBy lebelle
    @Transactional
    public int deleteByLibelle(String libelle) {
        return competenceDao.deleteByLibelle(libelle);
    }

    //     find liste competence
    public List<Competence> findByUserLogin(String login) {
        return competenceDao.findByUserLogin(login);
    }

    // delete liste competence
    @Transactional
    public int deleteByUserLogin(String login) {
        return competenceDao.deleteByUserLogin(login);
    }
}
