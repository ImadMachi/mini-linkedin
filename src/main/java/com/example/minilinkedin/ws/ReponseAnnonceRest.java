package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.service.facade.ReponseAnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reponseAnnonce")
public class ReponseAnnonceRest {
    @PostMapping("/")
    public int save(@RequestBody ReponseAnnonce reponseAnnonce) {
        return reponseAnnonceService.exec(reponseAnnonce);
    }

    @GetMapping("/ref/{ref}")
    public ReponseAnnonce findByRef(@PathVariable String ref) {
        return reponseAnnonceService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return reponseAnnonceService.deleteByRef(ref);
    }

    @GetMapping("/user/login/{login}")
    public List<ReponseAnnonce> findByUserLogin(@PathVariable String login) {
        return reponseAnnonceService.findByUserLogin(login);
    }

    @DeleteMapping("/user/login/{login}")
    public int deleteByUserLogin(@PathVariable String login) {
        return reponseAnnonceService.deleteByUserLogin(login);
    }

    @Autowired
    private ReponseAnnonceService reponseAnnonceService;
}
