package com.mijael.tracker.beans;

import lombok.*;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Builder
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false,length = 25)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date dueTo;


}
