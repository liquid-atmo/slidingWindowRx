package com.liquidatmo.reactiveslidingaverage.service;
import com.liquidatmo.reactiveslidingaverage.Entity.User;
import com.liquidatmo.reactiveslidingaverage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Sinks.Many<User> userSink;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userSink = Sinks.many().unicast().onBackpressureBuffer();
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Flux<User> searchByName(String name, int limit) {
        return userRepository.findByNameIgnoreCaseContaining(name)
        .take(limit); // Applying back pressure by limiting the number of elements
    }
}