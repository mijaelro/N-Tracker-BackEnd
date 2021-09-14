package com.mijael.tracker.serviceImpl;

import com.mijael.tracker.beans.*;
import com.mijael.tracker.exceptions.IllegalActionException;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.services.ClientService;
import com.mijael.tracker.services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.List;

@Service
@Scope("prototype")
@Getter
@RequiredArgsConstructor
public class UserServiceImpl extends ClientService implements UserService {

    private final TokenManager tokenManager;
    private int userId;
    private String userName;


    @Override
    public boolean logIn(String email, String password) throws LoginException {
        boolean isLoggedIn = userRepository.existsByEmailAndPassword(email, password);
        if (!isLoggedIn) {
            throw new LoginException("Error, Unable to logg in.. try again ");
        }
        userId = userRepository.findByEmailAndPassword(email, password).getId();
        userName = userRepository.findByEmailAndPassword(email,password).getFirstName();
        System.out.println("the user id is : " + userId);
        return isLoggedIn;
    }

    @Override
    public User userSignUp(String firstName, String lastName, String email, String password) throws IllegalActionException {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalActionException("Error , email: " + email
                    + "already exists , try adding a user with a different email");
        }
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
            userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public Expense addExpense(Expense expense) throws IllegalActionException {
        var user =userRepository.findById(expense.getUserId()).orElse(null);
        var expenses =  user.getExpenses();
        expenses.add(expense);
        user.setExpenses(expenses);
        userRepository.save(user);
        return expenseRepository.findByName(expense.getName());
    }

    @Override
    public void deleteExpense(int id) throws IllegalActionException {
        Expense expense = expenseRepository.findById(id).orElseThrow(()->new IllegalActionException("Expense by the id " +id + "doesn't exist"));
        expenseRepository.delete(expense);
        System.out.println("Expense by the id " +id + "was deleted successfully");
    }

    @Override
    public Expense updateExpense(Expense expense) throws IllegalActionException {
        Expense toUpdate = expenseRepository.findById(expense.getId()).orElseThrow(()->new IllegalActionException("Expense by the id " +expense.getId() + "doesn't exist"));
        expense.setId(toUpdate.getId());
        expenseRepository.save(expense);
        return expense;
    }

    @Override
    public Expense getOneExpense(int id) throws IllegalActionException {
        return expenseRepository.findById(id).orElseThrow(()->new IllegalActionException("Expense by the id " +id + "doesn't exist"));
    }

    @Override
    public List<Expense> getAllExpenses() throws IllegalActionException {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalActionException("no user by that id"));
        return user.getExpenses();
    }

    @Override
    public Link addLink(Link link) throws IllegalActionException {
        var user =userRepository.findById(link.getUserId()).orElse(null);
       var links =  user.getLinks();
        links.add(link);
        user.setLinks(links);
        userRepository.save(user);
        return linkRepository.findByName(link.getName());
    }

    @Override
    public void deleteLink(int id) throws IllegalActionException {
        Link link = linkRepository.findById(id).orElseThrow(()->new IllegalActionException("Link by the id " +id + "doesn't exist"));
        linkRepository.delete(link);
        System.out.println("Link by the id " +id + "was deleted successfully");

    }

    @Override
    public Link updateLink(Link link) throws IllegalActionException {
        Link toUpdate = linkRepository.findById(link.getId()).orElseThrow(()->new IllegalActionException("Link by the id " +link.getId() + "doesn't exist"));
        link.setId(toUpdate.getId());
        linkRepository.save(link);
        return link;
    }

    @Override
    public Link getOneLink(int id) throws IllegalActionException {
        return linkRepository.findById(id).orElseThrow(()->new IllegalActionException("Link by the id " +id + "doesn't exist"));
    }

    @Override
    public List<Link> getAllLinks() throws IllegalActionException {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalActionException("no user by that id"));
        return user.getLinks();
    }

    @Override
    public Todo addTodo(Todo todo) throws IllegalActionException {
        var user =userRepository.findById(todo.getUserId()).orElse(null);
        var todos =  user.getTodos();
        todos.add(todo);
        user.setTodos(todos);
        userRepository.save(user);
        return todoRepository.findByName(todo.getName());
    }

    @Override
    public void deleteTodo(int id) throws IllegalActionException {
        Todo todo = todoRepository.findById(id).orElseThrow(()->new IllegalActionException("Todo by the id " +id + "doesn't exist"));
        todoRepository.delete(todo);
        System.out.println("Todo by the id " +id + "was deleted successfully");

    }

    @Override
    public Todo updateTodo(Todo todo) throws IllegalActionException {
        Todo toUpdate = todoRepository.findById(todo.getId()).orElseThrow(()->new IllegalActionException("Todo by the id " +todo.getId() + "doesn't exist"));
        todo.setId(toUpdate.getId());
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public Todo getOneTodo(int id) throws IllegalActionException {
        return todoRepository.findById(id).orElseThrow(()->new IllegalActionException("Todo by the id " +id + "doesn't exist"));
    }

    @Override
    public List<Todo> getAllTodos() throws IllegalActionException {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalActionException("no user by that id"));
        return user.getTodos();
    }

}
