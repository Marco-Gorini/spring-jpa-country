package com.soprasteria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.bytebuddy.asm.Advice.Local;


@Entity
@Table(name = "continents")
public class Continent {
	
	//ATTRIBUTES
	
	
	@Id //Chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
	private int continent_id;
	
	private String name;
	
	//LINK TO FOREIGN KEY
	@OneToMany(mappedBy = "continent")
	private List<Region> regions;
	
	
	//GETTERS AND SETTERS

	
	public int getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(int continent_id) {
		this.continent_id = continent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	
	
}
