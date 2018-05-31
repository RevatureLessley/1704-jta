package com.revature.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BoringPokemon {
	
	private int pokedexId;
	private String name;
	private String primaryType;
	private String secondaryType;
	
	public BoringPokemon() {}

	public BoringPokemon(int pokedexId, String name, String primaryType, String secondaryType) {
		super();
		this.pokedexId = pokedexId;
		this.name = name;
		this.primaryType = primaryType;
		this.secondaryType = secondaryType;
	}

	public int getPokedexId() {
		return pokedexId;
	}

	public void setPokedexId(int pokedexId) {
		this.pokedexId = pokedexId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryType() {
		return primaryType;
	}

	public void setPrimaryType(String primaryType) {
		this.primaryType = primaryType;
	}

	public String getSecondaryType() {
		return secondaryType;
	}

	public void setSecondaryType(String secondaryType) {
		this.secondaryType = secondaryType;
	}

	@Override
	public String toString() {
		return "Pokemon [pokedexId=" + pokedexId + ", name=" + name + ", primaryType=" + primaryType
				+ ", secondaryType=" + secondaryType + "]";
	}
	
	
}
