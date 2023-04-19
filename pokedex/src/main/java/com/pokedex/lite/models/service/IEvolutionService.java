package com.pokedex.lite.models.service;

import java.util.List;

import com.pokedex.lite.models.entity.Evolution;
import com.pokedex.lite.models.entity.Pokemon;

public interface IEvolutionService {
	
	List<Evolution> EvolutionList();
	public void save (Evolution evolution);
	public Evolution searchById (Long id);
}
