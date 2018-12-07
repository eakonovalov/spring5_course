package com.eakonovalov.spring5petclinic.data;

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
        o.setId(1L);
        o.setFirstName("Ivan");
        o.setLastName("Ivanov");
        ownerRepository.save(o);

        o = new Owner();
        o.setId(2L);
        o.setFirstName("Petr");
        o.setLastName("Petrov");
        ownerRepository.save(o);

        o = new Owner();
        o.setId(3L);
        o.setFirstName("Alexander");
        o.setLastName("Alexandrov");
        ownerRepository.save(o);

        o = new Owner();
        o.setId(4L);
        o.setFirstName("Alexey");
        o.setLastName("Alexeev");
        ownerRepository.save(o);

        o = new Owner();
        o.setId(5L);
        o.setFirstName("Leonid");
        o.setLastName("Leonidov");
        ownerRepository.save(o);
    }

}
