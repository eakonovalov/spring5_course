package com.eakonovalov.spring5petclinic.data.config;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.data.repositories.VetRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
import com.eakonovalov.spring5petclinic.model.Vet;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestData {

    private OwnerRepository ownerRepository;
    private VetRepository vetRepository;

    public TestData(OwnerRepository ownerRepository, VetRepository vetRepository) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createOwners();
        createVets();
    }

    private void createOwners() {
        ownerRepository.save(new Owner("Ivan", "Ivanov"));
        ownerRepository.save(new Owner("Petr", "Petrov"));
        ownerRepository.save(new Owner("Alexander", "Alexandrov"));
        ownerRepository.save(new Owner("Alexey", "Alexeev"));
        ownerRepository.save(new Owner("Leonid", "Leonidov"));
    }

    private void createVets() {
        vetRepository.save(new Vet("Danil", "Danilov"));
        vetRepository.save(new Vet("Fedor", "Fedorov"));
    }
}
