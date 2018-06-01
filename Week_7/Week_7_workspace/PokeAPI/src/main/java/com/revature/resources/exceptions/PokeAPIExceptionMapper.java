package com.revature.resources.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PokeAPIExceptionMapper implements ExceptionMapper<PokeAPIException> {

	@Override
	public Response toResponse(PokeAPIException exception) {
		
		if(exception instanceof PokemonNotFoundException) {
			return Response.status(exception.getStatusCode())
							.entity(new FaultMessage(exception.getStatusCode(), exception.getMessage()))
							.type(MediaType.APPLICATION_JSON)
							.build();		
		}
		
		return Response.status(500)
						.entity(new FaultMessage(500, "Unknown exception thrown"))
						.type(MediaType.APPLICATION_JSON)
						.build();
	}

	
}
