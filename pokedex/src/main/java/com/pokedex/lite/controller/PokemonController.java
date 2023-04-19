package com.pokedex.lite.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pokedex.lite.models.entity.Ability;
import com.pokedex.lite.models.entity.Evolution;
import com.pokedex.lite.models.entity.Pokemon;
import com.pokedex.lite.models.service.IAbilityService;
import com.pokedex.lite.models.service.IEvolutionService;
import com.pokedex.lite.models.service.IPokemonService;
import com.pokedex.lite.helpers.ViewRouteHelper;

import jakarta.validation.Valid;

@Controller
@RequestMapping({ "/pokemon", "/" })
public class PokemonController {

	@Autowired
	private IPokemonService pokemonService;

	@Autowired
	private IAbilityService abilityService;

	@Autowired
	private IEvolutionService evolutionService;

	@GetMapping("/")
	public String pokemonList(Model model) {
		List<Pokemon> listedPokemon = pokemonService.findAllEnabled();

		model.addAttribute("title", "Pokémon List");
		model.addAttribute("pokemons", listedPokemon);

		return ViewRouteHelper.POKEMON_LIST;
	}

	@GetMapping("/register")
	public String Register(Model model) {
		Pokemon pokemon = new Pokemon();
		List<Ability> listedAbilities = abilityService.AbilityList();

		model.addAttribute("title", "New Pokémon");
		model.addAttribute("pokemon", pokemon);
		model.addAttribute("listedAbilities", listedAbilities);

		return ViewRouteHelper.POKEMON_FORM;
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Pokemon pokemon, BindingResult result, Model model) {
		List<Ability> listedAbilities = abilityService.AbilityList();

		if (result.hasErrors()) {
			model.addAttribute("title", "New Pokémon");
			model.addAttribute("pokemon", pokemon);
			model.addAttribute("listedAbilities", listedAbilities);
			return ViewRouteHelper.POKEMON_FORM;
		}

		pokemon.setEnabled(true);
		pokemonService.save(pokemon);
		return ViewRouteHelper.POKEMON_REDIRECT_LIST;
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long idPokemon, Model model) {
		Pokemon pokemon = null;

		if (idPokemon > 0) {
			pokemon = pokemonService.searchById(idPokemon);

			if (pokemon == null) {
				return ViewRouteHelper.POKEMON_REDIRECT_LIST;
			}
		} else {
			return ViewRouteHelper.POKEMON_REDIRECT_LIST;
		}

		List<Ability> listedAbilities = abilityService.AbilityList();

		model.addAttribute("title", "Edit Pokémon");
		model.addAttribute("pokemon", pokemon);
		model.addAttribute("listedAbilities", listedAbilities);

		return ViewRouteHelper.POKEMON_FORM;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long idPokemon) {
		Pokemon pokemon = null;

		if (idPokemon > 0) {
			pokemon = pokemonService.searchById(idPokemon);

			if (pokemon == null) {
				return ViewRouteHelper.POKEMON_REDIRECT_LIST;
			}
		} else {
			return ViewRouteHelper.POKEMON_REDIRECT_LIST;
		}

		pokemon.setEnabled(false);
		pokemonService.save(pokemon);

		return ViewRouteHelper.POKEMON_REDIRECT_LIST;
	}

	@GetMapping("/evolutions/{id}")
	public String evolutionList(@PathVariable("id") Long idPokemon, Model model) {
		Pokemon pokemon = pokemonService.searchById(idPokemon);
		
		List<Evolution> evolutions = evolutionService.findByPokemonIdAllEnabled(idPokemon);

		model.addAttribute("title", pokemon.getName() + "'s Evolutions");
		model.addAttribute("evolutions", evolutions);
		model.addAttribute("idPokemon", idPokemon);

		return ViewRouteHelper.EVOLUTION_LIST;
	}

	@GetMapping("/evolutions/{id}/register")
	public String evolutionRegister(@PathVariable("id") Long idPokemon, Model model) {
		List<Ability> listedAbilities = abilityService.AbilityList();

		Pokemon pokemon = pokemonService.searchById(idPokemon);

		Evolution evolution = new Evolution();
		evolution.setPokemon(pokemon);

		model.addAttribute("title", "New Evolution for " + pokemon.getName());
		model.addAttribute("evolution", evolution);
		model.addAttribute("listedAbilities", listedAbilities);

		return ViewRouteHelper.EVOLUTION_FORM;
	}

	@PostMapping("/evolutions/save")
	public String saveEvolution(@Valid @ModelAttribute Evolution evolution, BindingResult result, Model model) {
		List<Ability> listedAbilities = abilityService.AbilityList();

		if (result.hasErrors()) {
			model.addAttribute("title", "New Evolution for " + evolution.getPokemon().getName());
			model.addAttribute("evolution", evolution);
			model.addAttribute("listedAbilities", listedAbilities);

			return ViewRouteHelper.EVOLUTION_FORM;
		}

		evolution.setEnabled(true);
		evolutionService.save(evolution);
		return ViewRouteHelper.EVOLUTION_REDIRECT_LIST + evolution.getPokemon().getIdPokemon();
	}

	@GetMapping("/evolutions/edit/{id}")
	public String editEvolution(@PathVariable("id") Long idEvolution, Model model) {
		Evolution evolution = null;

		if (idEvolution > 0) {
			evolution = evolutionService.searchById(idEvolution);

			if (evolution == null) {
				return ViewRouteHelper.POKEMON_REDIRECT_LIST;
			}
		} else {
			return ViewRouteHelper.POKEMON_REDIRECT_LIST;
		}

		List<Ability> listedAbilities = abilityService.AbilityList();

		model.addAttribute("title", "Edit Pokémon");
		model.addAttribute("evolution", evolution);
		model.addAttribute("listedAbilities", listedAbilities);

		return ViewRouteHelper.EVOLUTION_FORM;
	}

	@GetMapping("/evolutions/delete/{id}")
	public String deleteEvolution(@PathVariable("id") Long idEvolution) {
		Evolution evolution = null;

		if (idEvolution > 0) {
			evolution = evolutionService.searchById(idEvolution);

			if (evolution == null) {

				return ViewRouteHelper.POKEMON_REDIRECT_LIST;
			}
		} else {
			return ViewRouteHelper.POKEMON_REDIRECT_LIST;
		}

		evolution.setEnabled(false);
		evolutionService.save(evolution);

		return ViewRouteHelper.EVOLUTION_REDIRECT_LIST + evolution.getPokemon().getIdPokemon();
	}

}
