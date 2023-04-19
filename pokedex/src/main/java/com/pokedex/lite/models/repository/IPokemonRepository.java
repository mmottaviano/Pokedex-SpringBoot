package com.pokedex.lite.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.pokedex.lite.models.entity.Pokemon;

public interface IPokemonRepository extends CrudRepository<Pokemon, Long> {
	
	@Query("SELECT p FROM Pokemon p WHERE p.name = (:name)")
	public abstract Pokemon findByName(@Param("name") String name);
	
	@Query("SELECT p FROM Pokemon p WHERE p.isEnabled = true")
	public abstract List<Pokemon> findAllEnabled();

}
