package com.soprasteria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Continent continent_id;
	
	
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

	public Continent getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(Continent continent_id) {
		this.continent_id = continent_id;
	}
	
	
	
	
	
}
