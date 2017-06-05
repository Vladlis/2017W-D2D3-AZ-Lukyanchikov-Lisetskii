package com.epam.webproject.service;

import com.epam.webproject.dao.AuthorDao;
import com.epam.webproject.domain.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dispatcher-servlet.xml")
public class AuthorServiceTest {

    @Mock
    private AuthorDao authorDao;

    @Autowired
    @InjectMocks
    private AuthorService authorService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetByName() {
        // given:
        List<Author> authors = new ArrayList<>();
        Author firstAuthor = new Author();
        firstAuthor.setName("firstAuthor");
        authors.add(firstAuthor);
        Author secondAuthor = new Author();
        secondAuthor.setName("secondAuthor");
        authors.add(secondAuthor);

        given(authorDao.getAll()).willReturn(authors);

        // when:
        Author actual = authorService.getByName("secondAuthor").orElse(null);

        // then:
        assertEquals(secondAuthor, actual);
    }
}
