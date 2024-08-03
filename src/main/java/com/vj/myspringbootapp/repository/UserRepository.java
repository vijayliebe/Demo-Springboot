package com.vj.myspringbootapp.repository;

import com.vj.myspringbootapp.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

public class UserRepository {
    private List<User> users = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(); // To simulate auto-increment IDs

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(Long id) {
        System.out.println("Searching for user with ID: " + id);
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public void save(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.add(user);
    }
}
