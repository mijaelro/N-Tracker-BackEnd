package com.mijael.tracker.clr;

import com.mijael.tracker.beans.ClientType;
import com.mijael.tracker.beans.Expense;
import com.mijael.tracker.beans.Link;
import com.mijael.tracker.beans.Todo;
import com.mijael.tracker.security.Information;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.services.LoginManagerService;
import com.mijael.tracker.services.UserService;
import com.mijael.tracker.utils.ArtUtils;
import com.mijael.tracker.utils.TestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

//@Component
@Order(3)
@RequiredArgsConstructor
public class UserServiceTesting implements CommandLineRunner {

    private final LoginManagerService loginManagerService;
    private final TokenManager tokenManager;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ArtUtils.USER_SERVICE_TESTING);

        TestUtils.testInfo("Login");
        String token = loginManagerService.logIn("mijael.rofe@hotmail.com", "Ewrty300", ClientType.USER);
        System.out.println(token);
        Information information = tokenManager.getMap().get(token);
        System.out.println(information);
        UserService userService = (UserService) information.getClientService();


        System.out.println(ArtUtils.EXPENSES);
        TestUtils.testInfo("GetAll-Expenses");
        userService.getAllExpenses().forEach(System.out::println);

        TestUtils.testInfo("Add-Expense");
        Expense expense = Expense.builder()
                .name("asd")
                .price(23)
                .description("desc")
                .purchaseDate(Date.valueOf(LocalDate.now()))
                .build();

        userService.addExpense(expense);
        System.out.println("expense added" + expense );

        TestUtils.testInfo("getOne-Expense");
        userService.getOneExpense(expense.getId());
        System.out.println( userService.getOneExpense(expense.getId()));

        TestUtils.testInfo("Update-Expense");
        expense.setName("lalalalala");
        userService.updateExpense(expense);
        System.out.println(userService.updateExpense(expense));

        TestUtils.testInfo("Delete-Expense");
        userService.deleteExpense(expense.getId());


        System.out.println(ArtUtils.TODOS);
        TestUtils.testInfo("getAll-Todos");
        userService.getAllTodos().forEach(System.out::println);

        TestUtils.testInfo("Add-Todo");
        Todo todo  = Todo.builder()
                .dueTo(Date.valueOf(LocalDate.now().plusDays(1)))
                .name("los")
                .description("los los los los")
                .build();
        userService.addTodo(todo);
        System.out.println("todo added " + todo);

        TestUtils.testInfo("getOne-Todo");
        userService.getOneTodo(todo.getId());
        System.out.println(userService.getOneTodo(todo.getId()));

        TestUtils.testInfo("Update-Todo");
        todo.setName("dsadasdasd");
        userService.updateTodo(todo);
        System.out.println(userService.updateTodo(todo));

        TestUtils.testInfo("Delete-Todo");
        userService.deleteTodo(todo.getId());


        System.out.println(ArtUtils.LINKS);
        TestUtils.testInfo("getAll-Links");
        userService.getAllLinks().forEach(System.out::println);

        TestUtils.testInfo("Add-Link");
        Link link = Link.builder()
                .path("http:somepath.com")
                .name("somenamessa")
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .build();
        userService.addLink(link);
        System.out.println(link);

        TestUtils.testInfo("getOne-Link");
        userService.getOneLink(link.getId());
        System.out.println(userService.getOneLink(link.getId()));

        TestUtils.testInfo("Update-Link");
        link.setName("kokokokokokok");
        userService.updateLink(link);
        System.out.println(userService.updateLink(link));

        TestUtils.testInfo("Delete-Link");
        userService.deleteLink(link.getId());



//-------------------------------------------Tests-Bad--------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------//
//        TestUtils.testInfo("Login-Bad");
//        UserService userService = (UserService) loginManagerService.logIn("mijael.rofe@hotmailas.com","Ewrty300", ClientType.USER);

//        Expenses----->

//        TestUtils.testInfo("Add-Expense-Bad");
//        Expense expense23 = Expense.builder()
//                .name("PC")
//                .price(23)
//                .description("desc")
//                .purchaseDate(Date.valueOf(LocalDate.now()))
//                .build();
//
//        userService.addExpense(expense23);

//        Expense expense23 = Expense.builder()
//                .name(null)
//                .price(23)
//                .description("desc")
//                .purchaseDate(Date.valueOf(LocalDate.now()))
//                .build();
//
//        userService.addExpense(expense23);

//        TestUtils.testInfo("getOne-Expense-Bad");
//        userService.getOneExpense(10);

//        TestUtils.testInfo("Update-Expense-Bad");
//        expense.setName("PC");
//        userService.updateExpense(expense);

//        expense.setName(null);
//        userService.updateExpense(expense);

//        TestUtils.testInfo("Delete-Expense-Bad");
//        userService.deleteExpense(10);


//          Todos------->

//        TestUtils.testInfo("Add-Todo-Bad");
//        Todo todo23  = Todo.builder()
//                .dueTo(Date.valueOf(LocalDate.now().plusDays(1)))
//                .name("MiBurger")
//                .description("los los los los")
//                .build();
//        userService.addTodo(todo23);

//        Todo todo23  = Todo.builder()
//                .dueTo(Date.valueOf(LocalDate.now().plusDays(1)))
//                .name(null)
//                .description("los los los los")
//                .build();
//        userService.addTodo(todo23);

//        TestUtils.testInfo("getOne-Todo-Bad");
//        userService.getOneTodo(10);

//        TestUtils.testInfo("Update-Todo-Bad");
//        todo.setName("MiBurger");
//        userService.updateTodo(todo);

//        todo.setName(null);
//        userService.updateTodo(todo);

//        TestUtils.testInfo("Delete-Todo-Bad");
//        userService.deleteTodo(10);


//        Links------------>

//        TestUtils.testInfo("Add-Link-Bad");
//        Link link23 = Link.builder()
//                .path("http:somepath.com")
//                .name("somenamessa")
//                .added(Date.valueOf(LocalDate.now().minusDays(1)))
//                .build();
//        userService.addLink(link23);

//        Link link23 = Link.builder()
//                .path("http:somepath.com")
//                .name(null)
//                .added(Date.valueOf(LocalDate.now().minusDays(1)))
//                .build();
//        userService.addLink(link23);

//        TestUtils.testInfo("getOne-Link-Bad");
//        userService.getOneLink(10);

//        TestUtils.testInfo("Update-Link");
//        link.setName("Full stack tutorial");
//        userService.updateLink(link);

//        link.setName(null);
//        userService.updateLink(link);

//        TestUtils.testInfo("Delete-Link-Bad");
//        userService.deleteLink(10);


    }
}
