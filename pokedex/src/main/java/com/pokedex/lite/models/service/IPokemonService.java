package com.pokedex.lite.models.service;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pokedex.lite.models.entity.Pokemon;

public interface IPokemonService {

	public List<Pokemon> listAll();
	public void save (Pokemon pokemon);
	public Pokemon searchById (Long id);
	public void delete (Long id);
	
	public Pokemon findByName(@Param("name") String name);
	public List<Pokemon> findAllEnabled();
}
