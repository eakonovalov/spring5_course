package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.data.config.TestConfiguration;
import com.eakonovalov.spring5petclinic.model.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class MapRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    public void findAll() {
        assertEquals(5, ownerRepository.findAll().size());
    }

    @Test
    public void findAllPageable() {
        Page<Owner> page = ownerRepository.findAll(PageRequest.of(0, 2));
        assertEquals(5, page.getTotalElements());
    }

    @Test
    public void count() {
        assertEquals(5, ownerRepository.count());
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        List<Owner> owners = ownerRepository.findByLastName("Ivanov");
        ownerRepository.deleteById(owners.get(0).getId());
        assertEquals(4, ownerRepository.findAll().size());
    }

    @Test
    @DirtiesContext
    public void delete() {
        List<Owner> owners = ownerRepository.findByLastName("Ivanov");
        ownerRepository.delete(owners.get(0));
        assertEquals(4, ownerRepository.findAll().size());
    }

    @Test
    public void findById() {
        List<Owner> owners = ownerRepository.findByLastName("Ivanov");
        Optional<Owner> optional = ownerRepository.findById(owners.get(0).getId());
        assertNotNull(optional.orElse(null));
        assertEquals("Ivan", optional.get().getFirstName());
        assertEquals("Ivanov", optional.get().getLastName());
    }
}
