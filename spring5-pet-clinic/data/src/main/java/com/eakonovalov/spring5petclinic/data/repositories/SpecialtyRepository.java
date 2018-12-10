package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
