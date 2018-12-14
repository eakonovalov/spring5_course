package com.eakonovalov.spring5recipe.repositories;

import com.eakonovalov.spring5recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
