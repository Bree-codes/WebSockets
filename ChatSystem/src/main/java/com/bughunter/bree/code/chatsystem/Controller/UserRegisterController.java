package com.bughunter.bree.code.chatsystem.Controller;

import com.bughunter.bree.code.chatsystem.Model.RegisterUserModel;
import com.bughunter.bree.code.chatsystem.Service.RegisterUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class UserRegisterController {
    private final RegisterUserService registerUserService;

    @PostMapping("/new-user")
    public ResponseEntity<String> createUser(@RequestBody RegisterUserModel registerUserModel){

        return registerUserService.addUser(registerUserModel);
    }
}
