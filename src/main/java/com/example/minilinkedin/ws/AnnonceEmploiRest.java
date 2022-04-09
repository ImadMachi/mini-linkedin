package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.service.facade.AnnonceEmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/annonceEmploi")
public class AnnonceEmploiRest {

    @GetMapping("/user/login/{loginUser}")
    public List<AnnonceEmploi> findAnnonceEmploisByLogin(@PathVariable String loginUser) {
        return annonceEmploiService.findAnnonceEmploisByLogin(loginUser);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteAnnonce(@PathVariable String ref) {
        return annonceEmploiService.deleteAnnonce(ref);
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
