package com.bughunter.bree.code.chatsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Integer userId;

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;
}
