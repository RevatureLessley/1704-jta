package com.revature.application;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.model.Pokemon;
import com.revature.service.PokemonLibrary;
import com.revature.service.PokemonNotFoundException;

public class Application {

	public static void main(String[] args) throws PokemonNotFoundException {
		final String serviceUrl = "http://localhost:8080/SOAPServer/PokemonLibrary";
		
		// Factory for creating JAX-WS proxies
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		// Set the Web Service to the factory
		factory.setServiceClass(PokemonLibrary.class);
		
		// Set where the Web Service can be located
		factory.setAddress(serviceUrl);
		
		// Logging handlers that outputs the bytes of the message
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		
		// Set the location of where the output of bytes will go
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		// Set the intercepts to the factory
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		
		// Consume the SOAP Web Service
		PokemonLibrary library = (PokemonLibrary) factory.create();
		List<Pokemon> pokemonList = library.getAllPokemon();
		
		for (Pokemon p : pokemonList) 
			System.out.println(p);
		
		Pokemon pikachu = library.getPokemon("Bidoof");
		System.out.println(pikachu);
	}

}
