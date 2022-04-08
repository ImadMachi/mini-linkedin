package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.ReponseAnnonce;

public interface ReponseAnnonceService {
     int save(ReponseAnnonce reponseAnnonce);
     ReponseAnnonce findByRef(String ref);
     int deleteByUserLogin(String login);
}
