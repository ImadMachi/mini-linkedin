package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRest {
    @PostMapping("/")
    public int exec(@RequestBody User user) {
        return userService.exec(user);
    }

    @DeleteMapping("/login/{login}")
    public int deleteByLogin(@PathVariable String login) {
        return userService.deleteByLogin(login);
    }

    @Autowired
    UserService userService;
}
