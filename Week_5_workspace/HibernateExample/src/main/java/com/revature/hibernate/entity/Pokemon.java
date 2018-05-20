package com.revature.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "pokemon")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Pokemon {

	@Id
	@GeneratedValue(generator = "pokemon_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "pokemon_seq", allocationSize = 1, initialValue = 1)
	@Column(name = "POKEMON_ID")
	private int id;

	@Column(name = "POKEMON_NAME")
	private String name;

	@ManyToMany(mappedBy = "pokemon", cascade = CascadeType.ALL)
	List<Trainer> trainers = new ArrayList<>();

	public Pokemon() {
	}

	public Pokemon(String name) {
		super();
		this.name = name;
	}

	public Pokemon(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + "]";
	}

	
	
}
