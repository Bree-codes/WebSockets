package com.bughunter.bree.code.chatsystem.Service;

import com.bughunter.bree.code.chatsystem.Entity.User;
import com.bughunter.bree.code.chatsystem.Model.RegisterUserModel;
import com.bughunter.bree.code.chatsystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;

    public ResponseEntity<String> addUser(RegisterUserModel registerUserModel){

        User user = new User();
        user.setEmail(registerUserModel.getEmail());
        user.setPassword(registerUserModel.getPassword());
        user.setFirstName(registerUserModel.getFirstName());
        user.setLastName(registerUserModel.getLastName());

        userRepository.save(user);

        return  new ResponseEntity<>("User Created Successfully", HttpStatus.OK);

    }
}
