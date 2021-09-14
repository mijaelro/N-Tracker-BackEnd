package com.mijael.tracker.clr;

import com.mijael.tracker.beans.Expense;
import com.mijael.tracker.beans.Link;
import com.mijael.tracker.beans.Todo;
import com.mijael.tracker.beans.User;
import com.mijael.tracker.repos.UserRepository;
import com.mijael.tracker.utils.ArtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;


@Component
@Order(1)
@RequiredArgsConstructor
public class InnitData implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(ArtUtils.INNIT_DATA);


        Expense expense = Expense.builder()
                .name("Phone")
                .description("Bougth a phone ")
                .purchaseDate(Date.valueOf(LocalDate.now()))
                .price(230.5)
                .userId(1)
                .build();

        Expense expense2 = Expense.builder()
                .name("PC")
                .description("Bougth a Pc ")
                .purchaseDate(Date.valueOf(LocalDate.now()))
                .price(230.5)
                .userId(2)
                .build();

        System.out.println(Arrays.asList(expense,expense2));

        Todo todo = Todo.builder()
                .name("clean")
                .description("finish cleaning house")
                .dueTo(Date.valueOf(LocalDate.now().minusDays(1)))
                .userId(1)
                .build();

        Todo todo2 = Todo.builder()
                .name("MiBurger")
                .description("finish project MiBurger")
                .dueTo(Date.valueOf(LocalDate.now().minusDays(1)))
                .userId(2)
                .build();

        Todo todo3 = Todo.builder()
                .name("Resume")
                .description("finish updating Resume/CV")
                .dueTo(Date.valueOf(LocalDate.now().minusDays(1)))
                .userId(1)
                .build();

        System.out.println(Arrays.asList(todo,todo2,todo3));


        Link link = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("code generators")
                .path("https://html-css-js.com/css/generator/")
                .userId(1)
                .build();

        Link link2 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("Full stack tutorial")
                .path("https://www.w3schools.com/whatis/whatis_fullstack.asp")
                .userId(2)
                .build();

        System.out.println(Arrays.asList(link,link2));

        User user1 = User.builder()
                .firstName("Avi")
                .lastName("Lala")
                .email("avilala@gmail.com")
                .password("12345678")
                .expense(expense)
                .todo(todo)
                .link(link)
                .build();

        User user2 = User.builder()
                .firstName("Mijael")
                .lastName("Rofe")
                .email("mijael.rofe@hotmail.com")
                .password("Ewrty300")
                .expense(expense2)
                .todo(todo2)
                .link(link2)
                .build();
        userRepository.saveAll(Arrays.asList(user1,user2));
        System.out.println(Arrays.asList(user1,user2));


    }


}
