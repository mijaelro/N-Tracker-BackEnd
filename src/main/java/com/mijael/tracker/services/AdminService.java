package com.mijael.tracker.services;

import com.mijael.tracker.beans.Expense;
import com.mijael.tracker.beans.Link;
import com.mijael.tracker.beans.Todo;
import com.mijael.tracker.beans.User;
import com.mijael.tracker.exceptions.IllegalActionException;

import java.util.List;

public interface AdminService {

    User getOneUser(int id) throws IllegalActionException;
    List<User> getAllUsers();
    void deleteUser(int id) throws IllegalActionException;
    User updateUser(User user) throws IllegalActionException;
    User addUser(User user) throws IllegalActionException;

    List<Expense> getAllExpenses();
    List<Link> getAllLinks();
    List<Todo> getAllTodos();

    Expense getOneExpense(int id) throws IllegalActionException;
    Link getOneLink(int id) throws IllegalActionException;
    Todo getOneTodo(int id) throws IllegalActionException;

    void deleteExpense(int id) throws IllegalActionException;
    void deleteLink(int id) throws IllegalActionException;
    void deleteTodo(int id) throws IllegalActionException;
}
