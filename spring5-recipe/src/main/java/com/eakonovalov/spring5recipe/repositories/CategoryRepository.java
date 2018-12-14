package com.eakonovalov.spring5recipe.repositories;

import com.eakonovalov.spring5recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
