package com.alexyom.dojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alexyom.dojos.models.Dojo;
import com.alexyom.dojos.models.Ninja;
import com.alexyom.dojos.repositories.DojoRepository;
import com.alexyom.dojos.repositories.NinjaRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	public DojoService(DojoRepository dRepo, NinjaRepository nRepo) {
		this.dojoRepo = dRepo;
		this.ninjaRepo = nRepo;
	}
	
	//Create a Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	//Create a Ninja
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	//Find all Dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	//Find All Ninjas
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	//Find Dojo
	public Dojo findDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
