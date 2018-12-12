package com.eakonovalov.spring5recipe.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes extends BaseEntity {

	@Lob
	private String text;
	@OneToOne
	private Recipe recipe;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
