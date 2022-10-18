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
@Table(name = "countries")
public class Country {
	
	
	//ATTRIBUTES
	
	
	@Id //Chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
	private int country_id;
	
	@Column(nullable = false)
	private String name;
	
	private float area;
	
	@Column(nullable = false)
	Local national_date;
	
	@Column(unique = true)
	private char [] country_code2 = new char[2];
	
	@Column(unique = true)
	private char [] country_code3 = new char[3];
	
	///FOREIGN KEY
	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;
	
	
	//GETTERS AND SETTERS

	
	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public Local getNational_date() {
		return national_date;
	}

	public void setNational_date(Local national_date) {
		this.national_date = national_date;
	}

	public char[] getCountry_code2() {
		return country_code2;
	}

	public void setCountry_code2(char[] country_code2) {
		this.country_code2 = country_code2;
	}

	public char[] getCountry_code3() {
		return country_code3;
	}

	public void setCountry_code3(char[] country_code3) {
		this.country_code3 = country_code3;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region_id) {
		this.region = region_id;
	}
	
	
}
