package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceDao extends JpaRepository<Competence,Long> {

    Competence findByLibelle(String libelle) ;

    int deleteByLibelle(String libelle);

    List<Competence> findByUserLogin(String login);

    int deleteByUserLogin(String login);

}
