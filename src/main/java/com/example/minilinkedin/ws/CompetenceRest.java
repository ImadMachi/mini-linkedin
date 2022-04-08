package com.example.minilinkedin.ws;

import com.example.minilinkedin.service.facade.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/competence")
public class CompetenceRest {
    @Autowired
   private CompetenceService competenceService;

}
