package com.alexyom.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexyom.dojos.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findAll();
	
	/*
	 * List<Task> findByTaskOrderByPriorityDesc(String task);
	 * 
	 * List<Task> findByTaskOrderByPriorityAsc(String task);
	 */
}
