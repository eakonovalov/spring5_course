package com.eakonovalov.spring5webapp.controllers;

import com.eakonovalov.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private static final String AUTHORS = "authors";

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute(AUTHORS, authorRepository.findAll());

        return AUTHORS;
    }

}
