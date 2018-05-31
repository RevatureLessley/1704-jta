package com.revature.model;

import java.io.Serializable;

public class Pokemon implements Serializable {

	private static final long serialVersionUID = -2355821901663085812L;
	private int pokedexId;
	private String name;
	private String type;
	
	public Pokemon() {}

	public Pokemon(int pokedexId, String name, String type) {
		super();
		this.pokedexId = pokedexId;
		this.name = name;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pokedexId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pokedexId != other.pokedexId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [pokedexId=" + pokedexId + ", name=" + name + ", type=" + type + "]";
	}
	
	

}
