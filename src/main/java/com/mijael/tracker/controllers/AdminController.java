package com.mijael.tracker.controllers;

import com.mijael.tracker.beans.Expense;
import com.mijael.tracker.beans.Link;
import com.mijael.tracker.beans.Todo;
import com.mijael.tracker.beans.User;
import com.mijael.tracker.exceptions.IllegalActionException;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private final TokenManager tokenManager;

    @PostMapping("user")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User addUser(@RequestHeader(value = "Authorization") String token, @RequestBody User user)
            throws IllegalActionException{
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.addUser(user);
    }

    @PutMapping("user")
    @ResponseStatus(code = HttpStatus.OK)
    public User updateUser(@RequestHeader(value = "Authorization") String token,@RequestBody User user)
            throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.updateUser(user);
    }

    @DeleteMapping("user/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestHeader(value = "Authorization") String token, @PathVariable int userId)
            throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        adminService.deleteUser(userId);
    }

    @GetMapping("users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getAllUsers(@RequestHeader(value = "Authorization") String token) {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getAllUsers();
    }

    @GetMapping("user/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getOneUser(@RequestHeader(value = "Authorization") String token, @PathVariable int userId)throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getOneUser(userId);
    }

    @GetMapping("links")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Link> getAllLinks(@RequestHeader(value = "Authorization") String token) {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getAllLinks();
    }

    @GetMapping("todos")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Todo> getAllTodos(@RequestHeader(value = "Authorization") String token) {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getAllTodos();
    }

    @GetMapping("expenses")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Expense> getAllExpenses(@RequestHeader(value = "Authorization") String token) {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getAllExpenses();
    }


    @GetMapping("link/{linkId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Link getOneLink(@RequestHeader(value = "Authorization") String token, @PathVariable int linkId)throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getOneLink(linkId);
    }

    @GetMapping("todo/{todoId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Todo getOneTodo(@RequestHeader(value = "Authorization") String token, @PathVariable int todoId)throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getOneTodo(todoId);
    }

    @GetMapping("expense/{expenseId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Expense getOneExpense(@RequestHeader(value = "Authorization") String token, @PathVariable int expenseId)throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        return adminService.getOneExpense(expenseId);
    }

    @DeleteMapping("link/{linkId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteLink(@RequestHeader(value = "Authorization") String token, @PathVariable int linkId)
            throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        adminService.deleteLink(linkId);
    }

    @DeleteMapping("todo/{todoId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTodo(@RequestHeader(value = "Authorization") String token, @PathVariable int todoId)
            throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        adminService.deleteTodo(todoId);
    }

    @DeleteMapping("expense/{expenseId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteExpense(@RequestHeader(value = "Authorization") String token, @PathVariable int expenseId)
            throws IllegalActionException {
        adminService= (AdminService) tokenManager.getService(token);
        adminService.deleteExpense(expenseId);
    }

}
