package com.pokedex.lite.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.pokedex.lite.models.entity.Ability;

public interface IAbilityRepository extends CrudRepository<Ability, Long> {

}
