package com.epam.webproject.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.epam.webproject.domain.Author;
import com.epam.webproject.domain.Book;
import com.epam.webproject.service.AuthorService;
import com.epam.webproject.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class UserControllerTest {

    @Mock
    private AuthorService authorService;
    @Mock
    private BookService bookService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAuthorByName() throws Exception {
        String name = "Pushkin";
        when(authorService.getByName(name)).thenReturn(Optional.of(new Author()));
        mockMvc.perform(get("/user/author")
                .param("authorName", name))
            .andExpect(status().isOk());
    }

    @Test
    public void testGetBookByName() throws Exception {
        String name = "Bible";
        when(bookService.getByName(name)).thenReturn(Optional.of(new Book()));
        mockMvc.perform(get("/user")
                .param("bookName", name))
            .andExpect(status().isOk());
    }
}