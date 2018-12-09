package com.eakonovalov.spring5petclinic.data.config;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class TestData {

    private OwnerRepository ownerRepository;

    public TestData(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void create() {
        Owner o = new Owner();
        o.setFirstName("Ivan");
        o.setLastName("Ivanov");
        ownerRepository.save(o);

        o = new Owner();
        o.setFirstName("Petr");
        o.setLastName("Petrov");
        ownerRepository.save(o);

        o = new Owner();
        o.setFirstName("Alexander");
        o.setLastName("Alexandrov");
        ownerRepository.save(o);

        o = new Owner();
        o.setFirstName("Alexey");
        o.setLastName("Alexeev");
        ownerRepository.save(o);

        o = new Owner();
        o.setFirstName("Leonid");
        o.setLastName("Leonidov");
        ownerRepository.save(o);
    }

}
