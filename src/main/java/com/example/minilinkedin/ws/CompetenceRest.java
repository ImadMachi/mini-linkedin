package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.service.facade.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competence")
public class CompetenceRest {
    @PostMapping("/")
    public int save(@RequestBody Competence competence) {
        return competenceService.save(competence);
    }
@GetMapping("/libelle/{libelle}")
    public Competence findByLibelle(@PathVariable String libelle) {
        return competenceService.findByLibelle(libelle);
    }
@DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return competenceService.deleteByLibelle(libelle);
    }
@GetMapping("/user/login")
    public List<Competence> findByUserLogin(@PathVariable String login) {
        return competenceService.findByUserLogin(login);
    }
@DeleteMapping("/user/login/{login}")
    public int deleteByUserLogin(@PathVariable String login) {
        return competenceService.deleteByUserLogin(login);
    }

    @Autowired
   private CompetenceService competenceService;

}
