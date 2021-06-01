package com.alexyom.license.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alexyom.license.models.License;
import com.alexyom.license.models.Person;
import com.alexyom.license.repositories.LicenseRepository;
import com.alexyom.license.repositories.PersonRepository;

@Service
public class DMVService {
	private final PersonRepository personRepo;
	private final LicenseRepository licRepo;
	public DMVService(PersonRepository pRepo, LicenseRepository licRepo) {
		this.personRepo = pRepo;
		this.licRepo = licRepo;
	}
	//Get a Person 
	public Person getPerson(Long id) {
		return personRepo.findById(id).orElse(null);
	}
	//Get all People
	public List<Person> getPeople() {
		return personRepo.findAll();
	}
	//Get Unlicensed People
	public List<Person> getUnlicensedPeople() {
		return personRepo.findByLicenseIdIsNull();
	}
	//Create Person
	public Person createPerson(Person p) {
		return personRepo.save(p);
	}
	//Generate License Number
	public int generateLicenseNumber() {
		License l = licRepo.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}
	//Create License
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return licRepo.save(l);
	}
	
}
