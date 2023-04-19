package com.pokedex.lite.models.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="evolution")
public class Evolution {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvolution;
	
	@Column(name = "name")
	@NotEmpty(message="The name can't be empty")
	private String name;
	
	@Column(name = "type")
	@NotEmpty(message="The type can't be empty")
	private String type;
	
	@Column(name = "extraType")
	private String extraType;
	
	@Column(name = "evolutionLevel")
	@NotNull(message="The level can't be empty")
	private int evolutionLevel;
	
	@Column(name = "isEnabled")
	private boolean isEnabled;
	
	@ManyToMany
	@NotEmpty(message="The ability can't be empty")
	private List<Ability> abilities;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pokemon")
	private Pokemon pokemon;	

	public Evolution() {
		super();
	}

	public Evolution(@NotEmpty(message = "The name can't be empty") String name,
			@NotEmpty(message = "The type can't be empty") String type, String extraType,
			@NotNull(message = "The level can't be empty") int evolutionLevel,
			@NotEmpty(message = "The ability can't be empty") List<Ability> abilities, Pokemon pokemon) {
		super();
		this.name = name;
		this.type = type;
		this.extraType = extraType;
		this.evolutionLevel = evolutionLevel;
		this.abilities = abilities;
		this.pokemon = pokemon;
	}

	public Long getIdEvolution() {
		return idEvolution;
	}

	public void setIdEvolution(Long idEvolution) {
		this.idEvolution = idEvolution;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExtraType() {
		return extraType;
	}

	public void setExtraType(String extraType) {
		this.extraType = extraType;
	}

	public int getEvolutionLevel() {
		return evolutionLevel;
	}

	public void setEvolutionLevel(int evolutionLevel) {
		this.evolutionLevel = evolutionLevel;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "Evolution [name=" + name + ", type=" + type + ", extraType=" + extraType + ", evolutionLevel="
				+ evolutionLevel + ", abilities=" + abilities + "]";
	}	
	

}
