package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.service.facade.AnnonceEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/annonceEmploi")
public class AnnonceEmploiRest {

    @DeleteMapping("/")
    public int deleteAnnonce(@RequestBody AnnonceEmploi annonceEmploi) {
        return annonceEmploiService.deleteAnnonce(annonceEmploi);
    }

    @GetMapping("/ref/{ref}")
    public AnnonceEmploi findByRef(@PathVariable String ref) {
        return annonceEmploiService.findByRef(ref);
    }

    @PostMapping("/")
    public int sauvgarder(@RequestBody AnnonceEmploi annonceEmploi) {
        return annonceEmploiService.sauvgarder(annonceEmploi);
    }

    @Autowired
    private AnnonceEmploiService annonceEmploiService;
}
