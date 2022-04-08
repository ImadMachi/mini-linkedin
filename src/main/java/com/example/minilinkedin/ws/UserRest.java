package com.example.minilinkedin.ws;

import com.example.minilinkedin.bean.User;
import com.example.minilinkedin.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserRest {
    @PostMapping("/")
    public int exec(@RequestBody User user) {
        return userService.exec(user);
    }

    @Autowired
    UserService userService;
}
