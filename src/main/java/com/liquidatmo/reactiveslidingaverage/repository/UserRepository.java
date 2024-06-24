package com.liquidatmo.reactiveslidingaverage.repository;

import com.liquidatmo.reactiveslidingaverage.Entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    // Custom query method to find users by name (case-insensitive) containing a given string
    @Query("SELECT * FROM users WHERE LOWER(name) LIKE '%' || LOWER(:name) || '%'")
    Flux<User> findByNameIgnoreCaseContaining(String name);
}