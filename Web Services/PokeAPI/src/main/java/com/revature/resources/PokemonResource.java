package com.revature.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

@Path("pokemon")
public class PokemonResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/pokemon
	public Response insertPokemon(Pokemon pokemon) {
		if (PokemonService.insertPokemon(pokemon)) {
			return Response.ok()
						   .build();
		}
		return Response.status(400).build();
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
		return Response.status(404).type(MediaType.APPLICATION_JSON).build();
	}
}















