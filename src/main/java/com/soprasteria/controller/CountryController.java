package com.soprasteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.model.Country;
import com.soprasteria.model.Region;
import com.soprasteria.repositories.CountryRepository;
import com.soprasteria.repositories.RegionRepository;

@RestController
@RequestMapping("/api")	
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/allcountries")
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
	
	@GetMapping("/country/{region}")
	public List<Country> getAllCountriesByRegion(@PathVariable(value = "region") int idRegion){
		Optional<Region> regionById = regionRepository.findById(idRegion);
		if(regionById.isPresent()) {
			return regionById.get().getCountries();
		}
		else {
			return new ArrayList<>();
		}
	}
}
