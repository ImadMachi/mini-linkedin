package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.ReponseAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponseAnnonceDao extends JpaRepository<ReponseAnnonce,Long> {
    ReponseAnnonce findByRef(String ref);

}
