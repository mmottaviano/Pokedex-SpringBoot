package com.pokedex.lite.models.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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
		Pokemon pokemon = new Pokemon("Spheal", "Ice", "Water", 3, null,  null);
		
		assertNotNull(pokemon);
	}
	
	@Test
	public void testFindbyName() {
		assertEquals(pokemonService.findByName("Lapras").getName(), "Lapras");
	}
	
	@Test
	public void testAddPokemon() {	
		Pokemon pokemon = new Pokemon("Seel", "Ice", "Water", 3, null,  null);
		pokemonService.save(pokemon);
		assertEquals(pokemonService.findByName("Seel").getName(), "Seel");
	}
	
	@Test
	public void testUpdatePokemon() {
		Pokemon pokemon = pokemonService.searchById(2L);
		pokemon.setName("Slowpoke");
		pokemonService.save(pokemon);

		assertEquals(pokemonService.findByName("Slowpoke").getName(), "Slowpoke");
	}
	
	

}
