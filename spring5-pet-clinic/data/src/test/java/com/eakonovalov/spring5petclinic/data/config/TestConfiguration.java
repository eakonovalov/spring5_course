package com.eakonovalov.spring5petclinic.data.config;

import com.eakonovalov.spring5petclinic.data.repositories.*;
import com.eakonovalov.spring5petclinic.model.Owner;
import com.eakonovalov.spring5petclinic.model.Pet;
import com.eakonovalov.spring5petclinic.model.PetType;
import com.eakonovalov.spring5petclinic.model.Vet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan({"com.eakonovalov.spring5petclinic.data"})
public class TestConfiguration {

    @Bean
    public OwnerRepository ownerRepository() {
        return new OwnerRepositoryImpl();
    }

    @Bean
    public VetRepository vetRepository() {
        return new VetRepositoryImpl();
    }

    @Bean
    public PetTypeRepository petTypeRepository() {
        return new PetTypeRepositoryImpl();
    }

    @Bean
    public PetRepository petRepository() {
        return new PetRepositoryImpl();
    }

    private class OwnerRepositoryImpl extends MapRepository<Owner, Long> implements OwnerRepository {

        @Override
        public List<Owner> findByLastName(String lastName) {
            List<Owner> result = new ArrayList<>();
            Map<Long, Owner> store = getStore();
            store.forEach((key, value) -> {
                if (value.getLastName().equals(lastName)) {
                    result.add(value);
                }
            });
            return result;
        }
    }

    private class VetRepositoryImpl extends MapRepository<Vet, Long> implements VetRepository {
    }

    private class PetTypeRepositoryImpl extends MapRepository<PetType, Long> implements PetTypeRepository {
    }

    private class PetRepositoryImpl extends MapRepository<Pet, Long> implements PetRepository {
    }
}
