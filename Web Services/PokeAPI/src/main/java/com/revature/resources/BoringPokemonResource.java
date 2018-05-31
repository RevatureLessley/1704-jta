package com.revature.resources;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.model.BoringPokemon;
import com.revature.service.BoringPokemonService;

@Path("boring-pokemon")
public class BoringPokemonResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/boring-pokemon
	public Response getAllPokemon(@Context HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println(header + " => " + request.getHeader(header));
		}
		return Response.ok()
					   .entity(BoringPokemonService.getAllBoringPokemon())
					   .build();
	}
	
	@GET
	@Path("/{someBoringPokemonName}")
	@Produces(MediaType.APPLICATION_JSON)
	// http://localhost:8080/PokeAPI/rest/boring-pokemon/someBoringPokemonName
	public Response getBoringPokemon(@PathParam("someBoringPokemonName") String name) {
		BoringPokemon p = BoringPokemonService.getBoringPokemon(name);
		if (p != null) {
			return Response.status(200)
						   .entity(p)
						   .build();
		}
		return Response.status(400)
					   .build();
	}
	
	
	@POST
	@Path("form-params")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response digestFormData(@FormParam("pokemonName") String name, @FormParam("pokemonType") String type) {
		System.out.println("Value for pokemonName: " + name);
		System.out.println("Value for pokemonType: " + type);
		return Response.ok().build();
	}
	
	@GET
	@Path("query-params")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response digestQueryParam(@QueryParam("type") String type) {
		for (BoringPokemon p : BoringPokemonService.getAllBoringPokemon()) {
			if (p.getPrimaryType().equals(type) | p.getSecondaryType().equals(type))
				return Response.ok().entity(p).build();
		}	
		return Response.status(404).build();
	}
}








