package com.epam.webproject.dao.impl;

import com.epam.webproject.dao.AuthorDao;
import com.epam.webproject.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AuthorDaoMock implements AuthorDao {

    private Map<Integer, Author> storage = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();

    {
        Author author = new Author("Nikolai Gogol", "Russia");
        author.setId(id.get());
        storage.put(id.getAndIncrement(), author);
        author = new Author("William Shakespeare", "England");
        author.setId(id.get());
        storage.put(id.getAndIncrement(), author);
        author = new Author("Sigmund Freud", "Austria");
        author.setId(id.get());
        storage.put(id.getAndIncrement(), author);
    }

    @Override
    public Author getById(int id) {
        return storage.get(id);
    }

    @Override
    public Author save(Author author) {
        author.setId(id.get());
        storage.put(id.getAndIncrement(), author);
        return author;
    }

    @Override
    public void remove(Author author) {
        storage.values().remove(author);
    }

    @Override
    public Collection<Author> getAll() {
        return storage.values();
    }
}
