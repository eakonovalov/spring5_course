package com.eakonovalov.spring5petclinic.repositories;

import com.eakonovalov.spring5petclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Long, Visit> {
}
