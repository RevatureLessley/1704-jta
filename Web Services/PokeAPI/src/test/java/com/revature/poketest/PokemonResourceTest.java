package com.revature.poketest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PokemonResourceTest {
	static int currentListOfPokemon = 1;
	static final String URL = "http://localhost:8080/PokeAPI/rest/pokemon";
	
	@Test(priority=1)
	public void getAllPokemon() {
		given()
		.when()
		.get(URL)
		.then()
		.assertThat()
		.body("pokemon", hasSize(currentListOfPokemon))
		.and()
		.statusCode(200);
	}
	
	@DataProvider(name="getPokemon")
	public Object[][] getPokemonDataProvider(){
		return new Object[][] {
			new Object[] { "Charmander", 4	}
		};
	}
	
	@Test(priority=2, dataProvider="getPokemon")
	public void getPokemon(String name, int pokedexId) {
		given()
		.pathParam("pokemonName", name)
		.when()
		.get(URL + "/{pokemonName}")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body("pokedexId", equalTo(pokedexId));
	}
	
	@DataProvider(name="nonExistentPokemon")
	public Object[][] nonExistentPokemonDataProvider(){
		return new Object[][] {
			new Object[] { "bidoof" }
		};
	}
	
	@Test(priority=3, dataProvider="nonExistentPokemon")
	public void getNonExistentPokemon(String name) {
		given()
			.pathParam("pokemonName", name)
			.when()
			.get(URL + "/{pokemonName}")
			.then()
			.assertThat()
			.statusCode(401)
			.and()
			.body("message", containsString(name + " does not exist"));
	}
	
	@POST
	@DataProvider(name="insertPokemon")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object[][] insertPokemonDataProvider(){
		return new Object[][] {
			new Object[] { "PokemonABCD", 1890}
		};
	}
	
	@Test(priority=4, dataProvider="insertPokemon")
	public void insertDummyPokemon(String name, int pokedexId) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("pokedexId", pokedexId);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
			.when()
			.post(URL)
			.then()
			.assertThat()
			.statusCode(200);
			
		given()
			.when()
			.get(URL)
			.then()
			.assertThat()
			.body("pokemon", hasSize(++currentListOfPokemon));
	}
	
	@DataProvider(name="updatePokemon")
	public Object[][] updatePokemonDataProvider(){
		return new Object[][] {
			new Object[] { "Digimon", 1890 }
		};
	}
	
	@Test(priority=5, dataProvider="updatePokemon")
	public void updatePokemon(String name, int pokdexId) {
		Map<String, Object> pokemonAsMap = new HashMap<>();
		pokemonAsMap.put("name", name);
		pokemonAsMap.put("pokedexId", pokdexId);
		
		given()
			.contentType(ContentType.JSON)
			.body(pokemonAsMap)
			.when()
			.put(URL)
			.then()
			.assertThat()
			.statusCode(200);
	}
	
	@Test(priority=5, dataProvider="deletePokemon")
	public void deleteDummyPokemon(String name) {
		given()
			.pathParam("pokemonToBeDeleted", name)
			.when()
			.delete(URL)
			.then()
			.assertThat()
			.statusCode(404);
		
		given()
			.when()
			.get(URL)
			.then()
			.assertThat()
			.body("pokemon", hasSize(--currentListOfPokemon));
			
	}
	
	@DataProvider(name="deletePokemon")
	public Object[][] deletePokemonDataProvider(){
		return new Object[][] {
			new Object[] { "Pokemonabcd" },
		};
	}
	
	
}
