package com.mijael.tracker.clr;

import com.mijael.tracker.beans.*;
import com.mijael.tracker.security.Information;
import com.mijael.tracker.security.TokenManager;
import com.mijael.tracker.services.AdminService;
import com.mijael.tracker.services.LoginManagerService;
import com.mijael.tracker.utils.ArtUtils;
import com.mijael.tracker.utils.TestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
@Order(2)
@RequiredArgsConstructor
public class AdminServiceTesting implements CommandLineRunner {

    private final LoginManagerService loginManagerService;
    private final TokenManager tokenManager;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(ArtUtils.ADMIN_SERVICE_TESTING);

        System.out.println(ArtUtils.USER);
        TestUtils.testInfo("Login");
        String token = loginManagerService.logIn("admin@admin.com", "admin", ClientType.ADMINISTRATOR);
        System.out.println(token);
        Information information = tokenManager.getMap().get(token);
        System.out.println(information);
        AdminService adminService = (AdminService) information.getClientService();


        TestUtils.testInfo("GetAll-Users");
        adminService.getAllUsers().forEach(System.out::println);

        TestUtils.testInfo("Add-User");
        User user = User.builder()
                .firstName("lana")
                .lastName("delRey")
                .email("lana@gmail.com")
                .password("12345678")
                .build();
        adminService.addUser(user);
        System.out.println("user added " + user);

        TestUtils.testInfo("GetOne-User");
        adminService.getOneUser(user.getId());
        System.out.println(adminService.getOneUser(user.getId()));

        TestUtils.testInfo("Update-User");
        user.setEmail("lanarararara");
        adminService.updateUser(user);
        System.out.println(adminService.updateUser(user));

        TestUtils.testInfo("Delete-User");
        adminService.deleteUser(user.getId());



        System.out.println(ArtUtils.EXPENSES);
        TestUtils.testInfo("GetAll-Expenses");
        adminService.getAllExpenses().forEach(System.out::println);

        TestUtils.testInfo("GetOne-Expense");
        Expense get = adminService.getOneExpense(1);
        System.out.println(get);

        TestUtils.testInfo("Delete-Expense");
        adminService.deleteExpense(1);



        System.out.println(ArtUtils.LINKS);
        TestUtils.testInfo("GetAll-Links");
        adminService.getAllLinks().forEach(System.out::println);

        TestUtils.testInfo("GetOne-Link");
        Link get1 = adminService.getOneLink(1);
        System.out.println(get1);

        TestUtils.testInfo("Delete-Link");
        adminService.deleteLink(1);



        System.out.println(ArtUtils.TODOS);
        TestUtils.testInfo("GetAll-Todos");
        adminService.getAllTodos().forEach(System.out::println);

        TestUtils.testInfo("GetOne-Todo");
        Todo get2 = adminService.getOneTodo(1);
        System.out.println(get2);

        TestUtils.testInfo("Delete-Todo");
        adminService.deleteTodo(1);



//-------------------------------------------Tests-Bad--------------------------------------------------------------------------------------//
//------------------------------------------------------------------------------------------------------------------------------------------//

//          Users----------->

//        TestUtils.testInfo("Login -Bad");
//        AdminService adminService = (AdminService) loginManagerService.logIn("admin@adminf.com","admin", ClientType.ADMINISTRATOR);

//        TestUtils.testInfo("Add-User-Bad");
//        User user1 = User.builder()
//                .firstName("lana")
//                .lastName("delRey")
//                .email("mijael.rofe@hotmail.com")
//                .password("12345678")
//                .build();
//        adminService.addUser(user1);

//        User user2 = User.builder()
//                .firstName("lana")
//                .lastName("delRey")
//                .email(null)
//                .password("12345678")
//                .build();
//        adminService.addUser(user2);

//        TestUtils.testInfo("GetOne-User-Bad");
//        adminService.getOneUser(10);

//        TestUtils.testInfo("Update-User-Bad");
//        user.setEmail("mijael.rofe@hotmail.com");
//        adminService.updateUser(user);

//        user.setEmail(null);
//        adminService.updateUser(user);

//        TestUtils.testInfo("Delete-User-Bad");
//        adminService.deleteUser(10);

//          Expenses------->

//        TestUtils.testInfo("GetOne-Expense-Bad");
//        adminService.getOneExpense(10);

//        TestUtils.testInfo("Delete-Expense-Bad");
//        adminService.deleteExpense(10);

//           Links-------->
//        TestUtils.testInfo("GetOne-Link-Bad");
//        adminService.getOneLink(10);

//        TestUtils.testInfo("Delete-Link-Bad");
//        adminService.deleteLink(10);

//          Todos--------->
//        TestUtils.testInfo("GetOne-Todo-Bad");
//        adminService.getOneTodo(10);

//        TestUtils.testInfo("Delete-Todo-Bad");
//        adminService.deleteTodo(10);

    }
}
