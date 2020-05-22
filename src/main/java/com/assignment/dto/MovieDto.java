package com.assignment.dto;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MovieDto implements Serializable{

	private long id;

	private String title;

	private String category;

	@NotNull
	@DecimalMin("0.5")
	@DecimalMax("5.0")
	private Float rating;

	public MovieDto() {
		super();
	}

	public MovieDto(String title, String category, float rating) {
		super();
		this.title = title;
		this.category = category;
		this.rating = rating;
	}

	public MovieDto(long id, String title, String category, float rating) {
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
