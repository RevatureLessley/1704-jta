package com.revature.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class Trainer {

	@Id
	@GeneratedValue(generator = "trainer_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "trainer_seq", allocationSize = 1)
	@Column(name = "trainer_id")
	private int id;

	@Column(name = "trainer_name")
	private String name;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	public Trainer() {
	}

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

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + "]";
	}

}
