package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.AnnonceEmploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnnonceEmploiDao extends JpaRepository<AnnonceEmploi,Long> {
    AnnonceEmploi findByRef(String ref);

    int deleteByRef(String ref);
}
