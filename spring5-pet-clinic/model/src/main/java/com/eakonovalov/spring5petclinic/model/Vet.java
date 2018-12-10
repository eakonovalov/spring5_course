package com.eakonovalov.spring5petclinic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "VET_SPECIALTY",
            joinColumns = @JoinColumn(name = "VET_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPECIALTY_ID"))
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
