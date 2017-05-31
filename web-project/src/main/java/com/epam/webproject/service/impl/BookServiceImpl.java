package com.epam.webproject.service.impl;

import com.epam.webproject.dao.BookDao;
import com.epam.webproject.domain.Author;
import com.epam.webproject.domain.Book;
import com.epam.webproject.service.AuthorService;
import com.epam.webproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Optional<Book> getByName(String name) {
        return bookDao.getAll().stream()
                .filter(author -> name.equals(author.getName()))
                .findFirst();
    }
}
