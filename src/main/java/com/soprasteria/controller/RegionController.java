package com.soprasteria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.model.Continent;
import com.soprasteria.model.Region;
import com.soprasteria.repositories.ContinentRepository;
import com.soprasteria.repositories.RegionRepository;

@RestController
@RequestMapping("/api")	

public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@GetMapping("/allregions")
	public List<Region> getAllRegions(){
		return (List<Region>) regionRepository.findAll();
	}
	
	@GetMapping("/region/{regionid}")
	public Region getCountryById(@PathVariable(value = "regiond") int idRegion) {
		Optional<Region> regionById = regionRepository.findById(idRegion);
		if(regionById.isPresent()) {
			return regionById.get();
		}
		else {
			return new Region();
		}
	}
	@GetMapping("/region/{continent}")
	public List<Region> getAllCountriesByRegion(@PathVariable(value = "continent") int idContinent){
		Optional<Continent> continentById = continentRepository.findById(idContinent);
		if(continentById.isPresent()) {
			return continentById.get().getRegions();
		}
		else {
			return new ArrayList<>();
		}
	}
}
