package com.eakonovalov.spring5petclinic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends Person {

    private String address;
    private String city;
    private String phone;
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pet> getPets() {
        return pets;
    }
}
