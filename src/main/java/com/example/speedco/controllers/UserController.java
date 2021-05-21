package com.example.speedco.controllers;

import com.example.speedco.DAO.repositories.UserRepository;
import com.example.speedco.DAO.specifications.UserSpecification;
import com.example.speedco.DAO.utils.SearchUtils;
import com.example.speedco.DAO.utils.UserFilter;
import com.example.speedco.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // create a filter object
    @PostMapping("/filter")
    public List<User> getFilteredUsers(@RequestBody UserFilter userFilter) {
        Specification<User> specification = SearchUtils.getSpec(userFilter);
        return userRepository.findAll(specification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/jpql/{name}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {
        List<User> users = userRepository.getUserByNameJPQL(name);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/sql/{name}")
    public ResponseEntity<List<User>> getUserByNameNative(@PathVariable String name) {
        List<User> users = userRepository.getUserByNameSQL(name);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PutMapping("/id")
    public ResponseEntity<User> create(@RequestBody User user, @PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok(String.format("User with id: %s successfully deleted", id));
    }
}
