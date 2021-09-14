package com.mijael.tracker.services;

import com.mijael.tracker.beans.*;
import com.mijael.tracker.exceptions.IllegalActionException;

import java.util.List;

public interface UserService {
    User userSignUp(String firstName, String lastName, String email, String password) throws IllegalActionException ;

    Expense addExpense(Expense expense) throws IllegalActionException;
    void deleteExpense (int id) throws IllegalActionException;
    Expense updateExpense(Expense expense) throws IllegalActionException;
    Expense getOneExpense(int id) throws IllegalActionException;
    List<Expense> getAllExpenses() throws IllegalActionException;

    Link addLink(Link link) throws IllegalActionException;
    void deleteLink (int id) throws IllegalActionException;
    Link updateLink(Link link) throws IllegalActionException;
    Link getOneLink(int id) throws IllegalActionException;
    List<Link> getAllLinks() throws IllegalActionException;

    Todo addTodo(Todo todo) throws IllegalActionException;
    void deleteTodo (int id) throws IllegalActionException;
    Todo updateTodo(Todo todo) throws IllegalActionException;
    Todo getOneTodo(int id) throws IllegalActionException;
    List<Todo> getAllTodos() throws IllegalActionException;

}
