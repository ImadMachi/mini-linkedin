package com.example.minilinkedin.service.impl;

import com.example.minilinkedin.bean.AnnonceEmploi;
import com.example.minilinkedin.bean.Competence;
import com.example.minilinkedin.bean.ReponseAnnonce;
import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.dao.UserDao;
import com.example.minilinkedin.service.facade.*;
import com.example.minilinkedin.service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String signIn(User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }
        User loadUserByUsername = loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(loadUserByUsername);
        return token;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null || user.getId() == null) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    private int validate(User user) {
        if (user.getLogin() == null) return -1;
        else if (userDao.findByLogin(user.getLogin()) != null) return -2;
        else if (user.getCompetences() == null || user.getCompetences().isEmpty()) return -3;
        else if (userDao.findByUsername(user.getUsername()) != null) return -4;

        else return 1;
    }

    private void hundleProcess(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        roleService.save(user.getAuthorities());
        userDao.save(user);
        saveCompetences(user);
    }

    private void saveCompetences(User user) {
        for (Competence c : user.getCompetences()) {
            c.setUser(user);
            competenceService.saveCompetence(c);
        }
    }

    public int exec(User user) {
        int res = validate(user);
        if (res > 0) hundleProcess(user);
        return res;
    }

    public void update(User user) {
        if (userDao.findByLogin(user.getLogin()) != null) {
            userDao.save(user);
        }
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    @Transactional
    public int deleteByLogin(String login) {
        User user = userDao.findByLogin(login);
        if (user == null) {
            return -1;
        } else {
            int res = 0;
            res += reponseAnnonceService.deleteByUserLogin(user.getLogin());
            res += competenceService.deleteByUserLogin(user.getLogin());
            res += userDao.deleteByLogin(login);
            return res;
        }
    }

    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private ReponseAnnonceService reponseAnnonceService;
    @Autowired
    AnnonceEmploiService annonceEmploiService;
    @Autowired
    private UserDao userDao;
}
