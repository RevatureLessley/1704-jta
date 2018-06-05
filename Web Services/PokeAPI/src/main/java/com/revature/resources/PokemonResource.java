package com.revature.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.model.Pokemon;
import com.revature.resources.exceptions.NonUniquePokemonException;
import com.revature.resources.exceptions.PokemonNotFoundException;
import com.revature.service.PokemonService;

@Path("pokemon")
public class PokemonResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/pokemon
	public Response insertPokemon(Pokemon pokemon) {
		if (PokemonService.insertPokemon(pokemon)) {
			return Response.ok()
						   .build();
		}
		throw new NonUniquePokemonException(400, "Our records indicate " + pokemon.getName() 
											+ " exists at provided pokedexId");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/pokemon
	public Response getAllPokemon() {
		return Response.ok()
				       .entity(PokemonService.getAllPokemon())
				       .type(MediaType.APPLICATION_JSON)
				       .build();
	}
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/pokemon/{name}
	public Response getPokemon(@PathParam("name") String name) {
		Pokemon p = PokemonService.getPokemon(name);
		if (p != null) {
			return Response.ok(p, MediaType.APPLICATION_JSON).build();
		}
		throw new PokemonNotFoundException(404, name + " does not exist");
	}
	
	@DELETE
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/pokemon/{name}
	public Response deletePokemon(@PathParam("name") String name) {
		if (PokemonService.deletePokemon(name))
			return Response.ok()
						   .build();
		throw new PokemonNotFoundException(400, name + " does not exist");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updatePokemon(Pokemon pokemon) {
		if (PokemonService.updatePokemon(pokemon)) {
			return Response.ok().build();
		}
		throw new PokemonNotFoundException(400, pokemon.getName() + " does not exist");
	}
}















