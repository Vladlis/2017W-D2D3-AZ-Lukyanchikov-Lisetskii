package com.epam.webproject.service.impl;

import com.epam.webproject.dao.AuthorDao;
import com.epam.webproject.domain.Author;
import com.epam.webproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Optional<Author> getByName(String name) {
        return authorDao.getAll().stream()
                .filter(author -> name.equals(author.getName()))
                .findFirst();
    }
}
