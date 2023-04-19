package com.pokedex.lite.models.repository;

import org.springframework.data.repository.CrudRepository;


import com.pokedex.lite.models.entity.Evolution;

public interface IEvolutionRepository extends CrudRepository<Evolution, Long> {

}
