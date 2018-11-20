package com.eakonovalov.spring5webapp.repository;

import com.eakonovalov.spring5webapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
