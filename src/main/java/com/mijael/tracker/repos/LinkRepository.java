package com.mijael.tracker.repos;

import com.mijael.tracker.beans.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Integer> {

    boolean existsByName(String name);
    Link findByName(String name);
}
