package com.alexyom.dojos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.dojos.models.Review;
import com.alexyom.dojos.models.User;
import com.alexyom.dojos.repositories.ReviewRepository;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository rRepo;
	
	//Get All Reviews
	public List<Review> getReviews() {
		return this.rRepo.findAll();
	}
	
	//Find Review By id
	public Review findById(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	
	//Create
	public Review create(Review review) {
		return this.rRepo.save(review);
	}
	
	//Update
	public Review update(Review review) {
		return this.rRepo.save(review);
	}
	
	//Delete
	public void delete(Long id) {
		this.rRepo.deleteById(id);
	}
	
	//Review on Book
	public void review(User reviewer, String review, String rating) {
		this.rRepo.save(new Review(reviewer, review, rating));
	}
	
	//Delete Review on Book
	public void deleteReview(Long id) {
		this.rRepo.deleteById(id);
	}
}

