package com.eakonovalov.spring5jokes;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private ChuckNorrisQuotes quotes = new ChuckNorrisQuotes();

    @RequestMapping("/")
    public String joke(Model model) {
        model.addAttribute("joke", quotes.getRandomQuote());

        return "joke";
    }

}
