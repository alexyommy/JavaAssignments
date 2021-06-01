package com.alexyom.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alexyom.dojos.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}
