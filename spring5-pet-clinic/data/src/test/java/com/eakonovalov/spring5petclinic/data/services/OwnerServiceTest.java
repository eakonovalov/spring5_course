package com.eakonovalov.spring5petclinic.data.services;

import com.eakonovalov.spring5petclinic.data.TestConfiguration;
import com.eakonovalov.spring5petclinic.data.TestData;
import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class OwnerServiceTest {

    @Autowired
    private OwnerService ownerService;
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
    public void testFindByLastName() {
        List<Owner> owners = ownerRepository.findByLastName("Petrov");
        assertEquals(1, owners.size());
        assertEquals("Petr", owners.get(0).getFirstName());
        assertEquals("Petrov", owners.get(0).getLastName());
    }

    @Test
    public void testRename() {
        Optional<Owner> optional = ownerRepository.findById(1L);
        ownerService.rename(optional.get().getId(), "Evgeny");

        optional = ownerRepository.findById(1L);
        assertEquals("Evgeny", optional.get().getFirstName());
    }
}
