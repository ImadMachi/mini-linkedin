package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.ReponseAnnonce;

import java.util.List;

public interface ReponseAnnonceService {
     List<ReponseAnnonce> findByUserLogin(String login);
     int save(ReponseAnnonce reponseAnnonce);
//     ReponseAnnonce findByRef(String ref);
     int deleteByUserLogin(String login);
}
