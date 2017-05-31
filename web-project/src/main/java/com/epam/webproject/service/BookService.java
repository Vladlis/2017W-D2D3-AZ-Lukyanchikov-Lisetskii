package com.epam.webproject.service;

import com.epam.webproject.domain.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> getByName(String name);
}
