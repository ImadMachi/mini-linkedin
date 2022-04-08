package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceDao extends JpaRepository<Competence,Long> {

}
