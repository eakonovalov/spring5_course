package com.eakonovalov.spring5petclinic.data.repositories;

import com.eakonovalov.spring5petclinic.data.TestConfiguration;
import com.eakonovalov.spring5petclinic.data.TestData;
import com.eakonovalov.spring5petclinic.model.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class MapRepositoryTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TestData testData;

    @Before
    public void setUp() {
        ownerRepository.deleteAll();
        testData.create();
    }

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
    public void deleteById() {
        ownerRepository.deleteById(1L);
        assertEquals(4, ownerRepository.findAll().size());
    }

    @Test
    public void delete() {
        Optional<Owner> optional = ownerRepository.findById(1L);
        assertNotNull(optional.orElse(null));
        ownerRepository.delete(optional.get());
        assertEquals(4, ownerRepository.findAll().size());
    }

    @Test
    public void findById() {
        Optional<Owner> optional = ownerRepository.findById(1L);
        assertNotNull(optional.orElse(null));
        assertEquals("Ivan", optional.get().getFirstName());
        assertEquals("Ivanov", optional.get().getLastName());
    }
}