package com.revature.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name="ADDRESS")
// @Cache annotation provides the caching strategy
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Address {

	@Id
	@GeneratedValue
	@Column(name="ADDRESS_ID")
	private int id;
	
	@Column(name="ADDRESS_STREET")
	private String street;
	
	@Column(name="ADDRESS_CITY")
	private String city;
	
	@OneToOne(mappedBy="address", cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	private Trainer trainer;
	
	public Address() {}

	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

	public Address(int id, String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + "]";
	}
	
	
}

















