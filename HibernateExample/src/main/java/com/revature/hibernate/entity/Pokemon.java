package com.revature.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="POKEMON")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Pokemon {

	@Id
	@GeneratedValue(generator="pokemon_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="pokemon_seq", allocationSize=1, initialValue=1)
	@Column(name="POKEMON_ID")
	private int id;
	
	@Column(name="POKEMON_NAME")
	private String name;
	
	@ManyToMany(mappedBy="pokemon", cascade=CascadeType.ALL)
	List<Trainer> trainers = new ArrayList<>();
	
	// I make the fetching of types eager since there can only be 2 types assigned to a pokemon
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pokemon")
	private List<Type> types = new ArrayList<>();
	
	public Pokemon() {}
	
	public Pokemon(String name) {
		this.name = name;
	}
	
	public Pokemon(int id, String name) {
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
	
	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
