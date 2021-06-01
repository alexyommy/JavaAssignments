package com.alexyom.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexyom.spring.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	List<Answer> findAll();
	
}
