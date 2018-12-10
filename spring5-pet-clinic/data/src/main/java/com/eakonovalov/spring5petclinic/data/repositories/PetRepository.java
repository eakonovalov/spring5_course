package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
