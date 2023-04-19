package com.pokedex.lite.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pokedex.lite.models.entity.Evolution;

public interface IEvolutionRepository extends CrudRepository<Evolution, Long> {

	@Query("SELECT e FROM Evolution e WHERE e.isEnabled = true AND e.pokemon.idPokemon = (:idPokemon)")
	public abstract List<Evolution> findByPokemonIdAllEnabled(@Param("idPokemon") Long idPokemon);
	
}
