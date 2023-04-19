package com.pokedex.lite.models.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pokedex.lite.models.entity.Pokemon;
import com.pokedex.lite.models.service.implementation.PokemonServiceImplement;
@SpringBootTest
public class PokemonServiceImplementTest {
	
	PokemonServiceImplement pokemonService = new PokemonServiceImplement();
	
	@Test
	public void testName() {
		Pokemon pokemon = new Pokemon();
		pokemon.setName("lapras");
		
		assertEquals("lapras", pokemon.getName());
	}
	
	@Test
	public void testNotNull() {
		Pokemon pokemon = new Pokemon();
		
		assertNotNull(pokemon);
	}
		
	@Test
	public void TestTU02FindbyName() {

		assertEquals(pokemonService.findByName("Lapras").getName(), "Lapras");
		
		//assertNotNull(pokemonService.findByName("Pepe"));
	}
	
	

}
