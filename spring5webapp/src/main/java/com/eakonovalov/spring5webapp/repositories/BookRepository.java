package com.eakonovalov.spring5webapp.repositories;

import com.eakonovalov.spring5webapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
