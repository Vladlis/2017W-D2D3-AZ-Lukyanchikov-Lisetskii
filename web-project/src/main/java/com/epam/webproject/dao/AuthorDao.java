package com.epam.webproject.dao;

import com.epam.webproject.domain.Author;

import java.util.Collection;

public interface AuthorDao {

    Author getById(int id);

    Author save(Author author);

    void remove(Author author);

    Collection<Author> getAll();
}
