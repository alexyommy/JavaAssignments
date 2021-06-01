package com.alexyom.dojos.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexyom.dojos.models.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findAll();
	
	List<Event> findByState(String state);
	List<Event> findByStateOrderByEventDateDesc(String state);
	
	List<Event> findByStateIsNot(String state);
	List<Event> findByStateIsNotOrderByEventDateDesc(String state);
}
