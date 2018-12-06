package com.eakonovalov.spring5petclinic.repositories;

import com.eakonovalov.spring5petclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Long, Vet> {
}
