package com.epam.webproject.dao;

import com.epam.webproject.domain.Book;

import java.util.Collection;

public interface BookDao {

    Collection<Book> getAll();
}
