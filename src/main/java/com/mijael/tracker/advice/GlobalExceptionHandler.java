package com.mijael.tracker.advice;

import com.mijael.tracker.exceptions.IllegalActionException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalActionException.class, Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handler1(Exception e) {
        return new ErrorDetails("Bad request", e.getMessage());
    }

    @ExceptionHandler({LoginException.class, SecurityException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDetails handler2(Exception e) {
        return new ErrorDetails("Unauthorized", e.getMessage());
    }
}