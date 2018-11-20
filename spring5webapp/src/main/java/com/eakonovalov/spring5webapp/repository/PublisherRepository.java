package com.eakonovalov.spring5webapp.repository;

import com.eakonovalov.spring5webapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
