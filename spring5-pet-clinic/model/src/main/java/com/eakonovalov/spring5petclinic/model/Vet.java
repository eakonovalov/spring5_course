package com.eakonovalov.spring5petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person {

    @OneToMany
    private Set<Specialty> specialties = new HashSet<>();

    public Vet() {
        super();
    }

    public Vet(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }
}
