package org.java.app.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable = false)
	@NotBlank
	@Length(min = 3, max = 60, message = "il nome deve essere almeno di 3 caratteri e un massimo di 60")
	private String name;
	
	@Lob
	@Column(length = 150)
	@NotBlank
	@Length(min = 3, message = "la descrizione deve essere almeno di 3 caratteri")
	private String overview;
	
	@Lob
	@NotBlank
	private String picture;
	
	@Column(nullable = false)
	@Min(value = 0, message = "Il valore deve essere maggiore o uguale a 0")
    @Max(value = 100, message = "Il valore deve essere minore o uguale a 100")
	private float price;
	
	public Pizza() {}

	public Pizza(String name, String overview, String picture, float price) {
		setName(name);
		setOverview(overview);
		setPicture(picture);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + getId() + ", name=" + getName() + ", overview=" + getOverview() + ", picture=" + getPicture() + ", price="
				+ getPrice() + "]";
	}

}
