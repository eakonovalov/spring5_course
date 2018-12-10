package com.eakonovalov.spring5petclinic.data.config;

import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.data.repositories.PetRepository;
import com.eakonovalov.spring5petclinic.data.repositories.PetTypeRepository;
import com.eakonovalov.spring5petclinic.data.repositories.VetRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
import com.eakonovalov.spring5petclinic.model.Pet;
import com.eakonovalov.spring5petclinic.model.PetType;
import com.eakonovalov.spring5petclinic.model.Vet;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TestData {

    private OwnerRepository ownerRepository;
    private VetRepository vetRepository;
    private PetTypeRepository petTypeRepository;
    private PetRepository petRepository;

    public TestData(OwnerRepository ownerRepository, VetRepository vetRepository,
                    PetTypeRepository petTypeRepository, PetRepository petRepository) {
        this.ownerRepository = ownerRepository;
        this.vetRepository = vetRepository;
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createOwnersWithPets();
        createVets();
    }

    private void createOwnersWithPets() {
        PetType dog = new PetType();
        dog = petTypeRepository.save(dog);
        PetType cat = new PetType();
        cat = petTypeRepository.save(cat);

        Owner ivan = new Owner("Ivan", "Ivanov");
        Owner petr = new Owner("Petr", "Petrov");
        Owner alexander = new Owner("Alexander", "Alexandrov");
        Owner alexey = new Owner("Alexey", "Alexeev");
        Owner leonid = new Owner("Leonid", "Leonidov");

        Pet bobik = new Pet("Bobik", LocalDate.now(), dog);
        Pet sharik = new Pet("Sharik", LocalDate.now(), dog);
        Pet murka = new Pet("Murka", LocalDate.now(), cat);

        ivan.getPets().add(bobik);
        bobik.setOwner(ivan);
        petr.getPets().add(sharik);
        sharik.setOwner(petr);
        alexey.getPets().add(murka);
        murka.setOwner(alexey);

        petRepository.save(bobik);
        petRepository.save(sharik);
        petRepository.save(murka);

        ownerRepository.save(ivan);
        ownerRepository.save(petr);
        ownerRepository.save(alexander);
        ownerRepository.save(alexey);
        ownerRepository.save(leonid);
    }

    private void createVets() {
        vetRepository.save(new Vet("Danil", "Danilov"));
        vetRepository.save(new Vet("Fedor", "Fedorov"));
    }
}
