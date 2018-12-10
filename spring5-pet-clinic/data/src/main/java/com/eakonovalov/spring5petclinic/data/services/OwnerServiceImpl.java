package com.eakonovalov.spring5petclinic.data.services;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void rename(Long id, String firstName) {
        Optional<Owner> optional = ownerRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Owner not found");
        }

        Owner owner = optional.get();
        owner.setFirstName(firstName);

        ownerRepository.save(owner);
    }
}
