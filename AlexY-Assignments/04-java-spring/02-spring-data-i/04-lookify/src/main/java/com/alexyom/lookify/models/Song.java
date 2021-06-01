package com.alexyom.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=2, max=100)
	@NotBlank
	private String name;
	@Size(min=2, max=100)
	@NotBlank
	private String artist;
	@Min(1)
	@Max(5)
	private int rating;
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
	public Song() {
	}
	
	public Song(String name, String artist, int rating) {
		this.name = name;
		this.artist = artist;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getArtist() {
		return artist;
	}

	public int getRating() {
		return rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
