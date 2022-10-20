package com.soprasteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.model.Country;
import com.soprasteria.model.Region;
import com.soprasteria.repositories.CountryRepository;
import com.soprasteria.repositories.RegionRepository;

@RestController
@RequestMapping("/api/countries")	
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("")
	public List<Country> getAllCountry(){
		return (List<Country>) countryRepository.findAll();
	}
	
	@GetMapping("/country/{countryid}")
	public Country getCountryById(@PathVariable(value = "countryid") int idCountry) {
		Optional<Country> countryById = countryRepository.findById(idCountry);
		if(countryById.isPresent()) {
			return countryById.get();
		}
		else {
			return new Country();
		}
	}
	
	@GetMapping("/region/{region}")
	public List<Country> getAllCountriesByRegion(@PathVariable(value = "region") int idRegion){
		Optional<Region> regionById = regionRepository.findById(idRegion);
		if(regionById.isPresent()) {
			return regionById.get().getCountries();
		}
		else {
			return new ArrayList<>();
		}
	}
	
	@PostMapping("/{regionid}")
	public ResponseEntity<Country> addCountry (@PathVariable(name = "regionid") int idRegion,@RequestBody Country countryToAdd){
		Optional<Region> region = regionRepository.findById(idRegion);
		if(region.isPresent()) {
			countryToAdd.setRegion(region.get());
		}
		else {
			return new ResponseEntity<Country> (HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Country> (countryRepository.save(countryToAdd), HttpStatus.CREATED);
	}
	
	@PutMapping("/country/{countryId}") 
	public ResponseEntity<Country>  updateStudent(
			@PathVariable(value = "countryId") int countryId,
			@RequestBody Country countryToUpdate) {
		
		Optional<Country> countryRequested = countryRepository.findById(countryId);
		if (countryRequested.isPresent()) {
			Country country = countryRequested.get();
			country.setArea(countryToUpdate.getArea());
			country.setCountryCode2(countryToUpdate.getCountryCode2());
			country.setCountryCode3(countryToUpdate.getCountryCode3());
			country.setName(countryToUpdate.getName());
			return new ResponseEntity<Country> (countryRepository.save(country),HttpStatus.OK);
		} else
			return new ResponseEntity<Country> ((Country) null, HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/country/{countryId}")
	public ResponseEntity<Integer> deleteStudentbyId(@PathVariable(value = "countryId") int countryId) {
		try {
			countryRepository.deleteById(countryId);
			return new ResponseEntity<Integer> (1,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Integer> (0,HttpStatus.BAD_REQUEST);
		}
	}
}
