package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.Competence;

import java.util.List;

public interface CompetenceService {

    int saveCompetence(Competence competence);
    Competence findByLibelle(String libelle);
    int deleteByLibelle(String libelle);
    List<Competence> findByUserLogin(String login);
    int deleteByUserLogin(String login);
}
