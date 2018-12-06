package com.eakonovalov.spring5petclinic.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends Person {

    private String address;

    private String city;

    private String telephone;

    private List<Pet> pets = new ArrayList<>();

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

    public List<Pet> getPets() {
        return pets;
    }

}
