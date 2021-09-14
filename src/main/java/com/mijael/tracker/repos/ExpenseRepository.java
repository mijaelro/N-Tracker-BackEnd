package com.mijael.tracker.repos;

import com.mijael.tracker.beans.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

    boolean existsByName(String name);
    Expense findByName(String name);

}
