package com.example.minilinkedin.ws;

import com.example.minilinkedin.service.facade.AnnonceEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/annonceEmploi")
public class AnnonceEmploiRest {
    @Autowired
    private AnnonceEmploiService annonceEmploiService;
}
