package com.epam.webproject.dao.impl;

import com.epam.webproject.dao.BookDao;
import com.epam.webproject.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BookDaoMock implements BookDao {

    private Map<Integer, Book> storage = new ConcurrentHashMap<>();
    private AtomicInteger id = new AtomicInteger();

    {
        Book book = new Book("The Government Inspector", 1);
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
        book = new Book("Dead Souls", 1);
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
        book = new Book("Romeo and Juliet", 2);
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
        book = new Book("Civilization and Its Discontents", 3);
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
        book = new Book("The Ego and the Id", 3);
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
        book = new Book("Beyond the Pleasure Principle", 3);
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
    }

    @Override
    public Book getById(int id) {
        return storage.get(id);
    }

    @Override
    public Book save(Book book) {
        book.setId(id.get());
        storage.put(id.getAndIncrement(), book);
        return book;
    }

    @Override
    public void remove(Book book) {
        storage.values().remove(book);
    }

    @Override
    public Collection<Book> getAll() {
        return storage.values();
    }
}
