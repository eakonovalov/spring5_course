package com.eakonovalov.spring5petclinic.repositories;

import com.eakonovalov.spring5petclinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Long, Owner> {
}
