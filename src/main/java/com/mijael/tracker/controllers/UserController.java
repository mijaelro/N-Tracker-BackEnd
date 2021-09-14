package com.mijael.tracker.controllers;

import com.mijael.tracker.beans.Expense;
import com.mijael.tracker.beans.Link;
import com.mijael.tracker.beans.Todo;
import com.mijael.tracker.exceptions.IllegalActionException;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.serviceImpl.UserServiceImpl;
import com.mijael.tracker.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    
    @Autowired
    private UserService userService;
    private final TokenManager tokenManager;

    @PostMapping("expense")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Expense addExpense(@RequestHeader(value = "Authorization") String token,@RequestBody Expense expense) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        expense.setUserId(((UserServiceImpl)userService).getUserId());
        var expense2 = userService.addExpense(expense);
        return expense2;
    };

    @DeleteMapping("expense/{expenseId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteExpense (@RequestHeader(value = "Authorization") String token,@PathVariable int expenseId) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        userService.deleteExpense(expenseId);
   };

    @PutMapping("expense")
    @ResponseStatus(code = HttpStatus.OK)
    public Expense updateExpense(@RequestHeader(value = "Authorization") String token,@RequestBody Expense expense) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        return userService.updateExpense(expense);
    };

    @GetMapping("expense/{expenseId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Expense getOneExpense(@RequestHeader(value = "Authorization") String token,@PathVariable int expenseId) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        return userService.getOneExpense(expenseId);
    };

    @GetMapping("expenses")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Expense> getAllExpenses(@RequestHeader(value = "Authorization") String token) throws IllegalActionException {
        userService = (UserService) tokenManager.getService(token);
        return userService.getAllExpenses();
    };

    @PostMapping("link")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Link addLink(@RequestHeader(value = "Authorization") String token,@RequestBody Link link) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        link.setUserId(((UserServiceImpl)userService).getUserId());
        var link2 = userService.addLink(link);
        return link2;
    };

    @DeleteMapping("link/{linkId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteLink (@RequestHeader(value = "Authorization") String token,@PathVariable int linkId) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        userService.deleteLink(linkId);
    };

    @PutMapping("link")
    @ResponseStatus(code = HttpStatus.OK)
    public Link updateLink(@RequestHeader(value = "Authorization") String token,@RequestBody Link link) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        return userService.updateLink(link);
    };

    @GetMapping("link/{linkId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Link getOneLink(@RequestHeader(value = "Authorization") String token,@PathVariable int linkId) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        return userService.getOneLink(linkId);
    };

    @GetMapping("links")
    @ResponseStatus(code= HttpStatus.OK)
    public List<Link> getAllLinks(@RequestHeader(value = "Authorization") String token) throws IllegalActionException {
        userService = (UserService) tokenManager.getService(token);
        return userService.getAllLinks();
    };

    @PostMapping("todo")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Todo addTodo(@RequestHeader(value = "Authorization") String token,@RequestBody Todo todo) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        todo.setUserId(((UserServiceImpl)userService).getUserId());
        var todo2 = userService.addTodo(todo);
        return todo2;
    };

    @DeleteMapping("todo/{todoId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteTodo (@RequestHeader(value = "Authorization") String token,@PathVariable int todoId) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        userService.deleteTodo(todoId);
    };

    @PutMapping("todo")
    @ResponseStatus(code = HttpStatus.OK)
    public Todo updateTodo(@RequestHeader(value = "Authorization") String token,@RequestBody Todo todo) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        return userService.updateTodo(todo);
    };

    @GetMapping("todo/{todoId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Todo getOneTodo(@RequestHeader(value = "Authorization") String token,@PathVariable int todoId) throws IllegalActionException{
        userService = (UserService) tokenManager.getService(token);
        return userService.getOneTodo(todoId);
    };

    @GetMapping("todos")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Todo> getAllTodos(@RequestHeader(value = "Authorization") String token) throws IllegalActionException {
        userService = (UserService) tokenManager.getService(token);
        return userService.getAllTodos();
    };




}
