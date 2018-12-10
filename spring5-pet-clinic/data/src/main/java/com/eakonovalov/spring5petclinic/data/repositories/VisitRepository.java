package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
