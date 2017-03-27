package com.epam.rest.dao;


import com.epam.rest.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoImpl implements UserDao {

    private final Map<Integer, User> storage = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public int add(User user) {
        storage.put(counter.get(), user);
        return counter.getAndAdd(1);
    }

    @Override
    public User update(User user) {
        return storage.put(user.getId(), user);
    }

    @Override
    public User delete(int id) {
        return storage.remove(id);
    }

    @Override
    public User get(int id) {
        return storage.get(id);
    }
}
