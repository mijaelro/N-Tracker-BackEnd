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
                .description("Bougth a new phone ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(8)))
                .price(2230.5)
                .userId(1)
                .build();

        Expense expense2 = Expense.builder()
                .name("PC")
                .description("Bougth a new computer ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(7)))
                .price(3230.5)
                .userId(1)
                .build();
        Expense expense3 = Expense.builder()
                .name("watch")
                .description("Bougth an Apple watch ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(6)))
                .price(1230.5)
                .userId(1)
                .build();

        Expense expense5 = Expense.builder()
                .name("vaccum")
                .description("Bougth a vaccum cleaner ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(5)))
                .price(1200.5)
                .userId(1)
                .build();

        Expense expense6 = Expense.builder()
                .name("tv")
                .description("Bougth a 55 inch tv ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(4)))
                .price(2230.5)
                .userId(1)
                .build();

        Expense expense7 = Expense.builder()
                .name("tami4")
                .description("Bougth a new cooler ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(3)))
                .price(4230.5)
                .userId(1)
                .build();

        Expense expense8 = Expense.builder()
                .name("Closet")
                .description("Bougth a new closet for my room ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(2)))
                .price(1030.5)
                .userId(1)
                .build();

        Expense expense9 = Expense.builder()
                .name("machine")
                .description("Bougth a beanz coffee machine ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusMonths(1)))
                .price(730.5)
                .userId(1)
                .build();

        Expense expense10 = Expense.builder()
                .name("charger")
                .description("Bougth a new pc charger ")
                .purchaseDate(Date.valueOf(LocalDate.now()))
                .price(200.5)
                .userId(1)
                .build();

        Expense expense11 = Expense.builder()
                .name("vape")
                .description("Bougth a new vape ")
                .purchaseDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .price(330.5)
                .userId(1)
                .build();

        Expense expense12 = Expense.builder()
                .name("theater")
                .description("Bougth a new sound system ")
                .purchaseDate(Date.valueOf(LocalDate.now().plusMonths(2)))
                .price(1830.5)
                .userId(1)
                .build();

        Expense expense13 = Expense.builder()
                .name("backpack")
                .description("Bougth a new backpack ")
                .purchaseDate(Date.valueOf(LocalDate.now().plusMonths(3)))
                .price(130.5)
                .userId(1)
                .build();

        Expense expense14 = Expense.builder()
                .name("clothes")
                .description("Bougth new clothes ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).plusMonths(1)))
                .price(730.5)
                .userId(1)
                .build();
        Expense expense15 = Expense.builder()
                .name("shoes")
                .description("Bougth 2 pairs of shoes ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).plusMonths(2)))
                .price(530.5)
                .userId(1)
                .build();

        Expense expense16 = Expense.builder()
                .name("tools")
                .description("Bougth home tools ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).plusMonths(3)))
                .price(930.5)
                .userId(1)
                .build();

        Expense expense17 = Expense.builder()
                .name("suca")
                .description("Bougth a sukka ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1)))
                .price(530.5)
                .userId(1)
                .build();

        Expense expense18 = Expense.builder()
                .name("window")
                .description("Bougth a window ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(1)))
                .price(330.5)
                .userId(1)
                .build();

        Expense expense19 = Expense.builder()
                .name("ps5")
                .description("Bougth the new ps5 ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(2)))
                .price(3230.5)
                .userId(1)
                .build();

        Expense expense20 = Expense.builder()
                .name("scooter")
                .description("Bougth a xiamoi scooter ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(3)))
                .price(2230.5)
                .userId(1)
                .build();

        Expense expense21 = Expense.builder()
                .name("pump")
                .description("Bougth a pump ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(4)))
                .price(1000.5)
                .userId(1)
                .build();

        Expense expense22 = Expense.builder()
                .name("utensils")
                .description("Bougth kitchen utencils ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(5)))
                .price(250.5)
                .userId(1)
                .build();

        Expense expense23 = Expense.builder()
                .name("Phone")
                .description("Bougth the new android ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(6)))
                .price(2230.5)
                .userId(1)
                .build();

        Expense expense24 = Expense.builder()
                .name(" bottle")
                .description("Bougth an electric buttle ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(7)))
                .price(130.5)
                .userId(1)
                .build();

        Expense expense25 = Expense.builder()
                .name("course")
                .description("Bougth a udemy cousrse ")
                .purchaseDate(Date.valueOf(LocalDate.now().minusYears(1).minusMonths(8)))
                .price(200.5)
                .userId(1)
                .build();


        System.out.println(Arrays.asList(expense,expense2,expense3,expense7,expense5,expense6,expense8,expense9,expense10,
                expense11,expense12,expense13,expense14,expense15,expense16,expense17,expense18,expense19,expense20,
                expense21,expense22,expense23,expense24,expense25));

        Todo todo = Todo.builder()
                .name("clean")
                .description("finish cleaning house")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(34)))
                .userId(1)
                .build();

        Todo todo2 = Todo.builder()
                .name("MiBurger")
                .description("finish project MiBurger")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(10)))
                .userId(1)
                .build();

        Todo todo3 = Todo.builder()
                .name("Resume")
                .description("finish updating Resume/CV")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(14)))
                .userId(1)
                .build();

        Todo todo4 = Todo.builder()
                .name("quizz")
                .description("finish doin quizz app")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(13)))
                .userId(1)
                .build();

        Todo todo5 = Todo.builder()
                .name("organize")
                .description("finish organizing codes")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(25)))
                .userId(1)
                .build();

        Todo todo6 = Todo.builder()
                .name("push")
                .description("push everything to cloud")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(23)))
                .userId(1)
                .build();

        Todo todo7 = Todo.builder()
                .name("review")
                .description("review job interview questions")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(32)))
                .userId(1)
                .build();

        Todo todo8 = Todo.builder()
                .name("buy")
                .description("buy a birthday gift")
                .dueTo(Date.valueOf(LocalDate.now().plusDays(31)))
                .userId(1)
                .build();

        System.out.println(Arrays.asList(todo,todo2,todo3,todo4,todo5,todo6,todo7,todo8));


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
                .userId(1)
                .build();

        Link link3 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("bigO sheet")
                .path("https://www.bigocheatsheet.com/")
                .userId(1)
                .build();

        Link link4 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("Css gradient generators")
                .path("https://cssgradient.io/")
                .userId(1)
                .build();
        Link link5 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("Grid generator")
                .path("https://grid.layoutit.com/")
                .userId(1)
                .build();

        Link link6 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("Flexy boxes")
                .path("https://the-echoplex.net/flexyboxes/")
                .userId(1)
                .build();
        Link link7 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("Material UI")
                .path("https://material-ui.com/getting-started/example-projects/")
                .userId(1)
                .build();

        Link link8 = Link.builder()
                .added(Date.valueOf(LocalDate.now().minusDays(1)))
                .name("ASCII generator")
                .path("https://fsymbols.com/generators/carty/")
                .userId(1)
                .build();
        System.out.println(Arrays.asList(link,link2,link3,link4,link5,link6,link7,link8));

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
                .expenses(Arrays.asList(
                        expense,expense2,expense3,expense7,expense5,expense6,expense8,expense9,expense10,
                        expense11,expense12,expense13,expense14,expense15,expense16,expense17,expense18,expense19,expense20,
                        expense21,expense22,expense23,expense24,expense25
                ))
                .todos(Arrays.asList(
                        todo,todo2,todo3,todo4,todo5,todo6,todo7,todo8
                ))
                .links(Arrays.asList(
                        link,link2,link3,link4,link5,link6,link7,link8
                ))
                .build();
        userRepository.saveAll(Arrays.asList(user1,user2));
        System.out.println(Arrays.asList(user1,user2));


    }


}
