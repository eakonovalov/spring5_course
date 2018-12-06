package com.eakonovalov.spring5petclinic.model;

import java.util.ArrayList;
import java.util.List;

public class Vet extends Person {

    private List<Specialty> specialties = new ArrayList<>();

    public List<Specialty> getSpecialties() {
        return specialties;
    }

}
