package com.epam.webproject.controller;

import com.epam.webproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/authors")
    public String getAuthorByName(Model model, @RequestParam("name") String authorName) {
        model.addAttribute("result", authorService.getByName(authorName).orElse(null));
        return "user/result";
    }

}
