package com.mijael.tracker.serviceImpl;

import com.mijael.tracker.beans.Expense;
import com.mijael.tracker.beans.Link;
import com.mijael.tracker.beans.Todo;
import com.mijael.tracker.beans.User;
import com.mijael.tracker.exceptions.IllegalActionException;
import com.mijael.tracker.services.AdminService;
import com.mijael.tracker.services.ClientService;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {

    @Override
    public boolean logIn(String email, String password) throws LoginException {
        boolean isLoggedIn = (email.equals("admin@admin.com") && password.equals("admin"));
        if (!isLoggedIn) {
            throw new LoginException("Error , unable to logg in .. try again");
        }
        System.out.println("Admin was loggedIn successfully");

        return true;
    }


    @Override
    public User getOneUser(int id) throws IllegalActionException {
        return userRepository.findById(id).orElseThrow(()->new IllegalActionException("User by the id " +id + "doesn't exist"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) throws IllegalActionException {
      User user = userRepository.findById(id).orElseThrow(()->new IllegalActionException("User by the id " +id + "doesn't exist"));
      userRepository.delete(user);
        System.out.println("The User by the id " + id + "was deleted successfully");

    }

    @Override
    public User updateUser(User user) throws IllegalActionException {
        User user1 = userRepository.findById(user.getId()).orElseThrow(()->new IllegalActionException("User by the id " +user.getId() + "doesn't exist"));
        user.setId(user1.getId());
        userRepository.save(user);
        return user;
    }

    @Override
    public User addUser(User user) throws IllegalActionException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalActionException("Error , email: " + user.getEmail()
                    + "already exists , try adding a user with a different email");
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Expense getOneExpense(int id) throws IllegalActionException {
        return expenseRepository.findById(id).orElseThrow(()->new IllegalActionException("Expense by the id " +id + "doesn't exist"));
    }

    @Override
    public Link getOneLink(int id) throws IllegalActionException {
        return linkRepository.findById(id).orElseThrow(()->new IllegalActionException("Link by the id " +id + "doesn't exist"));
    }

    @Override
    public Todo getOneTodo(int id) throws IllegalActionException {
        return todoRepository.findById(id).orElseThrow(()->new IllegalActionException("Todo by the id " +id + "doesn't exist"));
    }

    @Override
    public void deleteExpense(int id) throws IllegalActionException {
        Expense expense =expenseRepository.findById(id).orElseThrow(()->new IllegalActionException("Expense by the id " +id + "doesn't exist"));
        expenseRepository.delete(expense);
        System.out.println("The Expense by the id " + id + "was deleted successfully");
    }

    @Override
    public void deleteLink(int id) throws IllegalActionException {
        Link link = linkRepository.findById(id).orElseThrow(()->new IllegalActionException("Link by the id " +id + "doesn't exist"));
        linkRepository.delete(link);
        System.out.println("The Link by the id " + id + "was deleted successfully");

    }

    @Override
    public void deleteTodo(int id) throws IllegalActionException {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new IllegalActionException("Todo by the id " +id + "doesn't exist"));
        todoRepository.delete(todo);
        System.out.println("The Todo by the id " + id + "was deleted successfully");

    }

}
