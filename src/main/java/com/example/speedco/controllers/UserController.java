package com.example.speedco.controllers;

import com.example.speedco.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getUsers() {
        return null;
    }

    @PostMapping("/filter")
    public Page<User> getFilteredUsers() {
        return null;
    }
}
