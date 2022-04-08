package com.example.minilinkedin.service.facade;

import com.example.minilinkedin.bean.AnnonceEmploi;

public interface AnnonceEmploiService {
    AnnonceEmploi findByRef(String ref);
    int sauvgarder(AnnonceEmploi annonceEmploi);
}
