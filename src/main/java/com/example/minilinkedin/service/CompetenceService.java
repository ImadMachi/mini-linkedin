package com.example.minilinkedin.service;

import com.example.minilinkedin.dao.CompetenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {
    @Autowired
    private CompetenceDao competenceDao;
}
