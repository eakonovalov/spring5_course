package com.eakonovalov.spring5petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vet extends Person {

    @OneToMany
    private List<Specialty> specialties = new ArrayList<>();

    public Vet() {
        super();
    }

    public Vet(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }
}
