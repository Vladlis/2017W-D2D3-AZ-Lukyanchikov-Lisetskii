package com.epam.webproject.controller;

import com.epam.webproject.service.AuthorService;
import com.epam.webproject.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/author")
    public String getAuthorByName(Model model, @RequestParam("name") String authorName) {
        model.addAttribute("result", authorService.getByName(authorName).orElse(null));
        return "user/result";
    }

    @RequestMapping("/book")
    public String getBookByName(Model model, @RequestParam("name") String bookName) {
        model.addAttribute("result", bookService.getByName(bookName).orElse(null));
        return "user/result";
    }

}
