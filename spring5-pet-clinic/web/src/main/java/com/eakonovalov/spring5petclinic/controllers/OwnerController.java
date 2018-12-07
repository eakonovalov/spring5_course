package com.eakonovalov.spring5petclinic.controllers;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.data.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private OwnerRepository ownerRepository;
    private OwnerService ownerService;

    public OwnerController(OwnerRepository ownerRepository, OwnerService ownerService) {
        this.ownerRepository = ownerRepository;
        this.ownerService = ownerService;
    }

    @RequestMapping("/owners")
    public String getAuthors(Model model) {
        model.addAttribute("owners", ownerRepository.findAll());

        return "owners";
    }
}
