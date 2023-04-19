package com.pokedex.lite.models.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="ability")
public class Ability {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAbility;
	
	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@ManyToMany(mappedBy = "abilities")
	private List<Pokemon> pokemons;
	
	@ManyToMany(mappedBy = "abilities")
	private List<Evolution> evolutions;

	public Ability() {
		super();
	}

	public Ability(@NotEmpty String name) {
		super();
		this.name = name;
	}

	public Long getIdAbility() {
		return idAbility;
	}

	public void setIdAbility(Long idAbility) {
		this.idAbility = idAbility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public List<Evolution> getEvolutions() {
		return evolutions;
	}


	public void setEvolutions(List<Evolution> evolutions) {
		this.evolutions = evolutions;
	}


	@Override
	public String toString() {
		return name;
	}	
	

	
	
	
}
