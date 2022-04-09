package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.AnnonceEmploi;

import java.util.List;

public interface AnnonceEmploiService {
    List<AnnonceEmploi> findAnnonceEmploisByLogin(String loginUser);
    AnnonceEmploi findByRef(String ref);
    int sauvgarder(AnnonceEmploi annonceEmploi);
    int deleteAnnonce(String ref);
}
