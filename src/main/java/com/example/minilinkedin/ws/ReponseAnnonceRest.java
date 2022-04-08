package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.service.facade.ReponseAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reponseAnnonce")
public class ReponseAnnonceRest {
@PostMapping("/")
    public int save(@RequestBody ReponseAnnonce reponseAnnonce) {
        return reponseAnnonceService.save(reponseAnnonce);
    }
@GetMapping("/ref/{ref}")
    public ReponseAnnonce findByRef(@PathVariable String ref) {
        return reponseAnnonceService.findByRef(ref);
    }
@DeleteMapping("/user/login/{login}")
    public int deleteByUserLogin(@PathVariable String login) {
        return reponseAnnonceService.deleteByUserLogin(login);
    }

    @Autowired
    private ReponseAnnonceService reponseAnnonceService;
}
