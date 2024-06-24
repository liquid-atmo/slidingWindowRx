package com.liquidatmo.reactiveslidingaverage.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {

    @Id
    private Long id;
    private String name;
    private String email;

    // Getters and setters (or use Lombok annotations)
}