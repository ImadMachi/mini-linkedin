package com.example.minilinkedin.dao;

import com.example.minilinkedin.bean.ReponseAnnonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseAnnonceDao extends JpaRepository<ReponseAnnonce,Long> {
    ReponseAnnonce findByRef(String ref);
    List<ReponseAnnonce> findByUserLogin(String login);
    int deleteByUserLogin(String login);
}
