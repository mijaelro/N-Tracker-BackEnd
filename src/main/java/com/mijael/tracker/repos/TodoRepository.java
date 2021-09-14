package com.mijael.tracker.repos;

import com.mijael.tracker.beans.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
    boolean existsByName(String name);
    Todo findByName(String name);
}
