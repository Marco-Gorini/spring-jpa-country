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
@Table(name = "continents")
public class Continent {
	@Id //Chiave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremento
	private int continent_id;
	
	private String name;
}
