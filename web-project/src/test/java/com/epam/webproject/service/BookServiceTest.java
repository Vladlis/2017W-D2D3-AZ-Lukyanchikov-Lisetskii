package com.epam.webproject.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.webproject.dao.BookDao;
import com.epam.webproject.domain.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class BookServiceTest {

    @Mock
    private BookDao bookDao;

    @Autowired
    @InjectMocks
    private BookService bookService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetByName() {
        List<Book> books = new ArrayList<>();
        Book firstBook = new Book();
        firstBook.setName("firstBook");
        books.add(firstBook);
        Book secondBook = new Book();
        secondBook.setName("secondBook");
        books.add(secondBook);

        when(bookDao.getAll()).thenReturn(books);
        assertEquals(firstBook, bookService.getByName("firstBook").orElse(null));
    }
}
