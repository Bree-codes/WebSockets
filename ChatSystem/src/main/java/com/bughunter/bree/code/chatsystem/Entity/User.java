package com.bughunter.bree.code.chatsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;


}
