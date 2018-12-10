package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
