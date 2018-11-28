package com.eakonovalov.spring5petclinic.model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Integer petId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

}
