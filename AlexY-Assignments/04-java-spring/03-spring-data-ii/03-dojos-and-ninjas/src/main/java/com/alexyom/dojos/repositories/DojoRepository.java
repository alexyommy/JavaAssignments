package com.alexyom.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alexyom.dojos.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
