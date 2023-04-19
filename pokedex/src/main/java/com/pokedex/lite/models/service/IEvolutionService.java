package com.pokedex.lite.models.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.pokedex.lite.models.entity.Evolution;

public interface IEvolutionService {
	
	List<Evolution> EvolutionList();
	public void save (Evolution evolution);
	public Evolution searchById (Long id);
	public List<Evolution> findByPokemonIdAllEnabled(@Param("idPokemon") Long idPokemon);

}
