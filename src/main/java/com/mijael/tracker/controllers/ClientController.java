package com.mijael.tracker.controllers;

import com.mijael.tracker.beans.User;
import com.mijael.tracker.controllers.models.req.LoginRequest;
import com.mijael.tracker.controllers.models.req.SignUpRequest;
import com.mijael.tracker.controllers.models.resp.LoginResponse;
import com.mijael.tracker.controllers.models.resp.SignUpResponse;
import com.mijael.tracker.exceptions.IllegalActionException;
import com.mijael.tracker.exceptions.TokenErrorException;
import com.mijael.tracker.security.Information;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.services.LoginManagerService;
import com.mijael.tracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;
    private final LoginManagerService loginManager;


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) throws SecurityException, LoginException {
        String token =loginManager.logIn(req.getEmail(),req.getPassword(),req.getClientType());
        Information information = tokenManager.getMap().get(token);
            LoginResponse response = LoginResponse.builder()
                .token(token)
                .clientType(information.getClientType())
                .clientName(information.getClientName())
                .clientId(information.getClientId())
            .build();
        return new ResponseEntity(response,HttpStatus.CREATED);
    };

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("logout")
    public void logout(@RequestHeader("Authorization") String token) throws TokenErrorException {
        tokenManager.deleteToken(token);
        System.out.println(token);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> customerSignUp(@RequestBody SignUpRequest req) throws IllegalActionException, LoginException, SecurityException {
        User user = userService.userSignUp(req.getFirstName(),req.getLastName(),req.getEmail(),req.getPassword());
        String token = loginManager.logIn(req.getEmail(),req.getPassword(), req.getClientType());
        SignUpResponse response =SignUpResponse.builder()
                .token(token)
                .clientId(user.getId())
                .clientName(req.getFirstName())
                .clientType(req.getClientType())
                .build();
        return new ResponseEntity(response,HttpStatus.CREATED);
    }



}
