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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="TRAINER")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Trainer {

	@Id
	@GeneratedValue(generator="trainer_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="trainer_seq", allocationSize=1)
	@Column(name="TRAINER_ID")
	private int id;
	
	@Column(name="TRAINER_NAME")
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="TRAINER_POKEMON",
			   joinColumns= { @JoinColumn(name="TRAINER_ID") },
			   inverseJoinColumns = { @JoinColumn(name="POKEMON_ID") })
	List<Pokemon> pokemon = new ArrayList<>();
	
	public Trainer() {}
	
	public Trainer(String name) {
		super();
		this.name = name;
	}

	public Trainer(int id, String name) {
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + "]";
	}
	
	
}









