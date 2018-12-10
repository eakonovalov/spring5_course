package com.eakonovalov.spring5petclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pet extends NamedEntity {

    private LocalDate birthDate;
    @OneToOne
    private PetType type;
    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;
    @OneToMany
    private List<Visit> visits = new ArrayList<>();

    public Pet() {
    }

    public Pet(String name, LocalDate birthDate, PetType type) {
        setName(name);
        this.birthDate = birthDate;
        this.type = type;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Visit> getVisits() {
        return visits;
    }
}
