package com.eakonovalov.spring5recipe.model;

import javax.persistence.Entity;

@Entity
public class Notes extends BaseEntity {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
