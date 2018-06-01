package com.revature.pokeTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PokemonResourceTest {
	
	static int currentListOfPokemon = 11;
	static final String URL = "http://localhost:8080/PokeAPI/rest/pokemon";
	
	@Test(priority = 1)
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
	
	@Test(priority = 2, dataProvider = "getPokemon")
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
	
	@DataProvider(name = "getPokemon")
	public Object[][] getPokemonDataProvider(){
		return new Object[][] {
			new Object[] {
					"Charmander", 4
					
			},
			new Object[] {
					"Squirtle", 7
					
			},
			new Object[] {
					"Pikachu", 25
					
			},
			new Object[] {
					"Golem", 76
					
			},
			new Object[] {
					"Gengar", 94
					
			},
			new Object[] {
					"Onix", 95
					
			},
			new Object[] {
					"Rhydon", 112
					
			},
			new Object[] {
					"Porygon", 137
					
			},
			new Object[] {
					"Snorlax", 143 
					
			},
			new Object[] {
					"Kingdra", 230
					
			},
			new Object[] {
					"Sylveon", 700 
					
			}

		};
			
	}
	
	@DataProvider(name = "nonExistentPokemon")
	public Object[][] nonExistentPokemonDataProvider(){
		return new Object [][] {
			new Object[] {
					"Bidoof"
			}
		};
	}
	
	@Test(priority = 3, dataProvider = "nonExistentPokemon")
	public void getNonExistentPokemon(String name) {
		given()
			.pathParam("pokemonName", name)
		.when()
			.get(URL + "/{pokemonName}")
		.then()
			.assertThat()
				.statusCode(404)
				.and()
					.body("message", containsString(name + " does not exist."));
	}
	
			
			
}
