package com.liquidatmo.reactiveslidingaverage.controller;

import com.liquidatmo.reactiveslidingaverage.Entity.User;
import com.liquidatmo.reactiveslidingaverage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/search")
    public Flux<User> searchUsers(@RequestParam String name, @RequestParam(defaultValue = "10") int limit) {
        // Assuming userService.searchByName returns a Flux<User> filtered by name
        return userService.searchByName(name, limit);
    }

    // You can add more endpoints for updating, deleting, etc.
}