package com.pokedex.lite.models.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokedex.lite.models.entity.Ability;
import com.pokedex.lite.models.repository.IAbilityRepository;
import com.pokedex.lite.models.service.IAbilityService;

@Service
public class AbilityServiceImplement implements IAbilityService {

	@Autowired
	private IAbilityRepository abilityRepository;
	
	@Override
	public List<Ability> AbilityList() {		
		return (List<Ability>) abilityRepository.findAll();
	}

}
