package com.epam.webproject.dao;

import com.epam.webproject.domain.Book;

import java.util.Collection;

public interface BookDao {

    Book getById(int id);

    Book save(Book book);

    void remove(Book book);

    Collection<Book> getAll();
}
