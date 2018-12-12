package com.eakonovalov.spring5recipe.model;

import javax.persistence.Entity;

@Entity
public class UnitOfMeasure extends BaseEntity {

	private Integer amount;
	private String name;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
