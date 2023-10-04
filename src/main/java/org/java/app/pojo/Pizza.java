package org.java.app.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 60, nullable = false)
	private String name;
	
	@Column(length = 150)
	private String overview;
	private String picture;
	
	@Column(nullable = false)
	private float price;

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
