package com.mijael.tracker.beans;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false ,length = 25)
    private String firstName;

    @Column(nullable = false  ,length = 25)
    private String lastName;

    @Column(nullable = false ,unique = true  ,length = 55)
    private String email;

    @Column(nullable = false  ,length = 25)
    private String password;

    @Singular
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(cascade=CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_expenses")
    private List<Expense> expenses;

    @Singular
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_links")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Link> links;

    @Singular
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_todos")
    @OneToMany(cascade =CascadeType.ALL)
    private List<Todo> todos;

}
