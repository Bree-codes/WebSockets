package com.bughunter.bree.code.chatsystem.Model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegisterUserModel {

    private String firstName;

    private String lastName;

    private String password;

    private String email;
}
