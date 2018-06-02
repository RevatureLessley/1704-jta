package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.revature.service.PokemonService;

@XmlRootElement
@Entity
@Table(name="POKE_API")
public class Pokemon implements Serializable {

	private static final long serialVersionUID = -5495795218263701248L;

	@Id
	@GeneratedValue(generator="poke_api_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="poke_api_seq", allocationSize=1, initialValue=1)
	@Column(name="POKEMON_ID")
	private int id;
	
	@Column(name="POKEMON_NAME")
	private String name;
	
	@Column(name="POKEDEX_ID", unique=true)
	private int pokedexId;
	
	@Column(name="POKEMON_IMAGE_URL")
	private String imageUrl;
	
	private static final String URL = "http://img.pokemondb.net/artwork/";
	
	public Pokemon() {}

	public Pokemon(String name, int pokedexId) {
		super();
		this.setName(name);
		this.pokedexId = pokedexId;
	}

	public Pokemon(int id, String name, int pokedexId) {
		super();
		this.id = id;
		this.setName(name);
		this.pokedexId = pokedexId;
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
		String temp = name.toLowerCase();
		this.name = temp.substring(0, 1).toUpperCase() + temp.substring(1);
		this.setImageUrl();
	}

	public int getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl() {
		this.imageUrl = URL + this.getName().toLowerCase() + ".jpg";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pokedexId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (id != other.id)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pokedexId != other.pokedexId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", pokedexId=" + pokedexId + ", imageUrl=" + imageUrl + "]";
	}
}
