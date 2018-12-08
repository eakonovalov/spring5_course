package com.eakonovalov.spring5petclinic.controllers;

import com.eakonovalov.spring5petclinic.data.repositories.VetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetRepository vetRepository;

    public VetController(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @RequestMapping("/vets")
    public String getAuthors(Model model) {
        model.addAttribute("vets", vetRepository.findAll());

        return "vets";
    }
}
