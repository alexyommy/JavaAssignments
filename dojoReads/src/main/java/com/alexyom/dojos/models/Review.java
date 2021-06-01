package com.alexyom.dojos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    private String name;
	
    @NotBlank
    private String author;
    
    @NotBlank
	private String description;
    
    @NotBlank
	private String rating;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //Users and Reviews
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_reviews", 
        joinColumns = @JoinColumn(name = "review_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> critics;
    
    //Reviews made by User
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User reviewer;
    
	public Review(User reviewer, String description, String rating) {
		this.reviewer = reviewer;
		this.description = description;
		this.rating = rating;
	}

	public Review() {
	}
	
	public List<User> getCritics() {
		return critics;
	}

	public void setCritics(List<User> critics) {
		this.critics = critics;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
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
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
