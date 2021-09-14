package com.mijael.tracker.repos;

import com.mijael.tracker.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findByFirstName(String name);

    boolean existsByEmailAndPassword(String email, String password) ;

    boolean existsByEmail(String email);
}
