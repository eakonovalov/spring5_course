package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
