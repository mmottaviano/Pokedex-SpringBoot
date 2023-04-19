package com.pokedex.lite.models.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="pokemon")
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPokemon;
	
	@Column(name = "name")
	@NotEmpty(message="The name can't be empty")
	private String name;
	
	@Column(name = "type")
	@NotEmpty(message="The type can't be empty")
	private String type;
	
	@Column(name = "extraType")
	private String extraType;
	
	@Column(name = "foundLevel")
	@NotNull(message="The level can't be empty")
	private int foundLevel;
	
	@Column(name = "isEnabled")
	private boolean isEnabled;
	
	@ManyToMany
	@NotEmpty(message="The ability can't be empty")
	private List<Ability> abilities;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pokemon", cascade = CascadeType.ALL)
	List<Evolution> evolutions;

	public Pokemon() {
		super();
	}

	public Pokemon(@NotEmpty(message = "The name can't be empty") String name,
			@NotEmpty(message = "The type can't be empty") String type, String extraType,
			@NotNull(message = "The level can't be empty") int foundLevel,
			@NotEmpty(message = "The ability can't be empty") List<Ability> abilities, List<Evolution> evolutions) {
		super();
		this.name = name;
		this.type = type;
		this.extraType = extraType;
		this.foundLevel = foundLevel;
		this.abilities = abilities;
		this.evolutions = evolutions;
	}

	public Long getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(Long idPokemon) {
		this.idPokemon = idPokemon;
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

	public int getFoundLevel() {
		return foundLevel;
	}

	public void setFoundLevel(int foundLevel) {
		this.foundLevel = foundLevel;
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

	public List<Evolution> getEvolutions() {
		return evolutions;
	}

	public void setEvolutions(List<Evolution> evolutions) {
		this.evolutions = evolutions;
	}

	@Override
	public String toString() {
		return "Pokemon [idPokemon=" + idPokemon + ", name=" + name + ", type=" + type + ", extraType=" + extraType
				+ ", foundLevel=" + foundLevel + ", isEnabled=" + isEnabled + ", abilities=" + abilities
				+ ", evolutions=" + evolutions + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abilities, evolutions, extraType, foundLevel, idPokemon, isEnabled, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(abilities, other.abilities) && Objects.equals(evolutions, other.evolutions)
				&& Objects.equals(extraType, other.extraType) && foundLevel == other.foundLevel
				&& Objects.equals(idPokemon, other.idPokemon) && isEnabled == other.isEnabled
				&& Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
	
	
	
	
}
