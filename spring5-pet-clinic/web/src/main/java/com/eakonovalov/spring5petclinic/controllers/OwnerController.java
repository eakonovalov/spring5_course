package com.eakonovalov.spring5petclinic.controllers;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @RequestMapping("/owners")
    public String getAuthors(Model model) {
        model.addAttribute("owners", ownerRepository.findAll());

        return "owners";
    }
}
