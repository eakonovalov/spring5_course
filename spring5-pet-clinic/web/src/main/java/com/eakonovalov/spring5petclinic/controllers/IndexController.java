package com.eakonovalov.spring5petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {

        return "index";
    }

    @RequestMapping("/oups")
    public String find() {
        return "not_implemented";
    }
}
