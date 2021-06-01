package com.alexyom.dojos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.dojos.models.Task;
import com.alexyom.dojos.models.User;
import com.alexyom.dojos.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository tRepo;
	
	//Get All Tasks
	public List<Task> getTasks() {
		return this.tRepo.findAll();
	}
	
	//Find Event By id
	public Task findById(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	//Create
	public Task create(Task task) {
		return this.tRepo.save(task);
	}
	
	//Update
	public Task update(Task task) {
		return this.tRepo.save(task);
	}
	
	//Delete
	public void delete(Long id) {
		this.tRepo.deleteById(id);
	}
	
	//Completed
	public void complete(Long id) {
		this.tRepo.deleteById(id);
	}

}
