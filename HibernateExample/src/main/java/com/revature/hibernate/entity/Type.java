package com.revature.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="TYPE")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Type {

	@Id
	@GeneratedValue
	@Column(name="TYPE_ID")
	private int id;
	
	@Column(name="TYPE_NAME")
	private String name;
	
	@ManyToOne(cascade= {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="POKEMON_ID")
	private Pokemon pokemon;
	
	public Type() {}
	
	public Type(String name) {
		this.name = name;
	}
	
	public Type(int id, String name) {
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

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + "]";
	}
	
	
}
