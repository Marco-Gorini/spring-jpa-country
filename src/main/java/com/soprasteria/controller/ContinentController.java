package com.soprasteria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.model.Continent;
import com.soprasteria.repositories.ContinentRepository;

@RestController
@RequestMapping("/api")	

public class ContinentController {
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@GetMapping("/allcontinents")
	public List<Continent> getAllContinents(){
		return (List<Continent>) continentRepository.findAll();
	}
	
	@GetMapping("/continent/{continentid}")
	public Continent getCountryById(@PathVariable(value = "continentid") int idContinent) {
		Optional<Continent> continentById = continentRepository.findById(idContinent);
		if(continentById.isPresent()) {
			return continentById.get();
		}
		else {
			return new Continent();
		}
	}
}
