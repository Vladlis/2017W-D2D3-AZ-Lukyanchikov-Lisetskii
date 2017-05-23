package com.epam.webproject.dao;

import com.epam.webproject.domain.Author;

import java.util.Collection;

public interface AuthorDao {

    Collection<Author> getAll();
}
