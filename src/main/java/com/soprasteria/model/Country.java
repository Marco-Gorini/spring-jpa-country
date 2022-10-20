package com.soprasteria.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import net.bytebuddy.asm.Advice.Local;


@Entity
@Table(name = "countries")
public class Country {
	
	
	//ATTRIBUTES
	
	
	@Id //Chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
	@Column(name = "country_id")
	private int idCountry;
	
	@Column(nullable = false)
	private String name;
	
	private float area;
	
//	@Column(nullable = false)
//	LocalDate national_day;
//	
	@Column(name = "country_code2",unique = true)
	private char [] countryCode2 = new char[2];
	
	@Column(name = "country_code3",unique = true)
	private char [] countryCode3 = new char[3];
	
	///FOREIGN KEY
	@ManyToOne
	@JoinColumn(name = "region_id")
	@JsonBackReference
	private Region region;
	
	
	//GETTERS AND SETTERS

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

//	public LocalDate getNational_day() {
//		return national_day;
//	}
//
//	public void setNational_day(LocalDate national_date) {
//		this.national_day = national_date;
//	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region_id) {
		this.region = region_id;
	}

	public int getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}

	public char[] getCountryCode2() {
		return countryCode2;
	}

	public void setCountryCode2(char[] countryCode2) {
		this.countryCode2 = countryCode2;
	}

	public char[] getCountryCode3() {
		return countryCode3;
	}

	public void setCountryCode3(char[] countryCode3) {
		this.countryCode3 = countryCode3;
	}
	
}
