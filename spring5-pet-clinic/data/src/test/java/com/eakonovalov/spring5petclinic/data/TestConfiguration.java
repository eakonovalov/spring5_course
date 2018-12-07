package com.eakonovalov.spring5petclinic.data;

import com.eakonovalov.spring5petclinic.data.repositories.MapRepository;
import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
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
}
