package com.pokedex.lite.models.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.lite.models.entity.Evolution;
import com.pokedex.lite.models.repository.IEvolutionRepository;
import com.pokedex.lite.models.service.IEvolutionService;

@Service
public class EvolutionServiceImplement implements IEvolutionService {
	
	@Autowired
	private IEvolutionRepository evolutionRepository;

	@Override
	public List<Evolution> EvolutionList() {	
		return (List<Evolution>) evolutionRepository.findAll();
	}

	@Override
	public void save(Evolution evolution) {
		evolutionRepository.save(evolution);
		
	}

	@Override
	public Evolution searchById(Long id) {		
		return evolutionRepository.findById(id).orElse(null);
	}

}
