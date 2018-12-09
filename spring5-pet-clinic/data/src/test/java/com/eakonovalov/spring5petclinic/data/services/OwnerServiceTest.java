package com.eakonovalov.spring5petclinic.data.services;

import com.eakonovalov.spring5petclinic.data.config.TestConfiguration;
import com.eakonovalov.spring5petclinic.data.config.TestData;
import com.eakonovalov.spring5petclinic.data.repositories.OwnerRepository;
import com.eakonovalov.spring5petclinic.model.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        List<Owner> owners = ownerRepository.findByLastName("Petrov");
        ownerService.rename(owners.get(0).getId(), "Evgeny");

        owners = ownerRepository.findByLastName("Petrov");
        assertEquals("Evgeny", owners.get(0).getFirstName());
    }
}
