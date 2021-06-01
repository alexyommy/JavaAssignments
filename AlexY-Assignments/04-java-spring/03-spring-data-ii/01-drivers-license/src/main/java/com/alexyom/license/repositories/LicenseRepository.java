package com.alexyom.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alexyom.license.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	public List<License> findAll();
	public License findTopByOrderByNumberDesc();
}
