package com.mijael.tracker.services;

import com.mijael.tracker.repos.ExpenseRepository;
import com.mijael.tracker.repos.LinkRepository;
import com.mijael.tracker.repos.TodoRepository;
import com.mijael.tracker.repos.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@NoArgsConstructor
public abstract class ClientService {

    @Autowired
    protected ExpenseRepository expenseRepository;

    @Autowired
    protected LinkRepository linkRepository;

    @Autowired
    protected TodoRepository todoRepository;

    @Autowired
    protected UserRepository userRepository;

    public abstract boolean logIn(String email, String password) throws LoginException;
}
