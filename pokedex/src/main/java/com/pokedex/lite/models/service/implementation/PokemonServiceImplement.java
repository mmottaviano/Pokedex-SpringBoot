package com.pokedex.lite.models.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.pokedex.lite.models.entity.Pokemon;
import com.pokedex.lite.models.repository.IPokemonRepository;
import com.pokedex.lite.models.service.IPokemonService;

@Service
public class PokemonServiceImplement implements IPokemonService {
	
	@Autowired
	private IPokemonRepository pokemonRepository;
	
	@Override
	public List<Pokemon> listAll() {		
		return (List<Pokemon>) pokemonRepository.findAll();
	}

	@Override
	public void save(Pokemon pokemon) {		
		pokemonRepository.save(pokemon);
	}

	@Override
	public Pokemon searchById(Long id) {		
		return pokemonRepository.findById(id).orElse(null);		
	}

	@Override
	public void delete(Long id) {
		pokemonRepository.deleteById(id);
	}
	
	@Override
	public Pokemon findByName(@Param("name") String name) {
		return pokemonRepository.findByName(name);		
	}	
	
	@Override
	public  List<Pokemon> findAllEnabled(){
		return pokemonRepository.findAllEnabled();
	}
	
}
