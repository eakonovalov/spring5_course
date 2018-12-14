package com.eakonovalov.spring5recipe.controllers;

import com.eakonovalov.spring5recipe.model.BaseEntity;
import com.eakonovalov.spring5recipe.model.Category;
import com.eakonovalov.spring5recipe.model.UnitOfMeasure;
import com.eakonovalov.spring5recipe.repositories.CategoryRepository;
import com.eakonovalov.spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "index", "/index.html"})
    public String index() {
        Optional<Category> c = categoryRepository.findByName("American");
        Optional<UnitOfMeasure> u = unitOfMeasureRepository.findByName("Teaspoon");

        System.out.println("Category ID: " + (c.map(BaseEntity::getId).orElse(null)));
        System.out.println("Unit ID: " + (u.map(BaseEntity::getId).orElse(null)));

        return "index.html";
    }
}
