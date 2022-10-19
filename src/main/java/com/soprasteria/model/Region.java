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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import net.bytebuddy.asm.Advice.Local;


@Entity
@Table(name = "regions")
public class Region {
	
	
	//ATTRIBUTES
	
	
	@Id //Chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
	private int region_id;
	
	private String name;
	
	///FOREIGN KEY
	@ManyToOne
	@JoinColumn(name = "continent_id")
	@JsonBackReference
	private Continent continent;
	
	//LINK TO FOREIGN KEY
	@OneToMany(mappedBy = "region")
	private List<Country> countries;
	
	//GETTERS AND SETTERS

	
	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent_id) {
		this.continent = continent_id;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
	
	
}
