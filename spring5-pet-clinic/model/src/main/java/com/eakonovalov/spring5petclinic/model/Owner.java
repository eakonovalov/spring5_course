package com.eakonovalov.spring5petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Owner extends Person {

    private String address;
    private String city;
    private String telephone;
    @OneToMany(mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    public Owner() {
        super();
    }

    public Owner(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }
}
