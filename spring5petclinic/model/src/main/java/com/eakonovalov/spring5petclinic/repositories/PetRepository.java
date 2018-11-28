package com.eakonovalov.spring5petclinic.repositories;

import com.eakonovalov.spring5petclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Long, Pet> {
}
