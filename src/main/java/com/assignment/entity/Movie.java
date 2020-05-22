package com.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String title;
	
	private String category;
	
	private float rating;

	public Movie() {
		super();
	}

	public Movie(String title, String category, float rating) {
		super();
		this.title = title;
		this.category = category;
		this.rating = rating;
	}

	public Movie(long id, String title, String category, float rating) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	

}
