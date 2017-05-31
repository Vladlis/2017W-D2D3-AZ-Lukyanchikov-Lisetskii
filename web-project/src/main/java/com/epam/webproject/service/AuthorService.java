package com.epam.webproject.service;

import com.epam.webproject.domain.Author;

import java.util.Optional;

public interface AuthorService {

    Optional<Author> getByName(String name);
}
