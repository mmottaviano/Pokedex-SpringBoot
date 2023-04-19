CREATE DATABASE  IF NOT EXISTS `pokedex`;
USE `pokedex`;

INSERT INTO ability VALUES (1,'Intimidation');
INSERT INTO ability VALUES (2,'Flame Body');
INSERT INTO ability VALUES (3,'Drizzle');
INSERT INTO ability VALUES (4,'Speed Boost');
INSERT INTO ability VALUES (5,'Battle Armor');
INSERT INTO ability VALUES (6,'Sturdy');
INSERT INTO ability VALUES (7,'Damp');
INSERT INTO ability VALUES (8,'Limber');
INSERT INTO ability VALUES (9,'Sand Veil');
INSERT INTO ability VALUES (10,'Static');

INSERT INTO pokemon (id_pokemon, name, type, extra_type, found_level, is_enabled)
VALUES (1,'Bulbasaur','Grass','Poison', 5, true);
INSERT INTO pokemon (id_pokemon, name, type, found_level, is_enabled)
VALUES (2,'Charmander','Fire', 5, true);
INSERT INTO pokemon (id_pokemon, name, type, found_level, is_enabled)
VALUES (3,'Squirtle','Water', 5, true);
INSERT INTO pokemon (id_pokemon, name, type, found_level, is_enabled)
VALUES (4,'Mankey','Fighting', 10, true);
INSERT INTO pokemon (id_pokemon, name, type, found_level, is_enabled)
VALUES (5,'Krabby','Water', 15, true);
INSERT INTO pokemon (id_pokemon, name, type, extra_type, found_level, is_enabled)
VALUES (6,'Aerodactyl','Rock','Flying', 20, true);
INSERT INTO pokemon (id_pokemon, name, type, extra_type, found_level, is_enabled)
VALUES (7,'Lapras','Water','ice', 40, true);
INSERT INTO pokemon (id_pokemon, name, type, found_level, is_enabled)
VALUES (8,'Snorlax','Normal', 25, true);
INSERT INTO pokemon (id_pokemon, name, type, extra_type, found_level, is_enabled)
VALUES (9,'Dratini','Dragon','Flying', 45, true);
INSERT INTO pokemon (id_pokemon, name, type, extra_type, found_level, is_enabled)
VALUES (10,'Zapdos','Electric','Flying', 60, true);
INSERT INTO pokemon (id_pokemon, name, type, found_level, is_enabled)
VALUES (11,'Mewtwo','Psychic', 80, true);

INSERT INTO pokemon_abilities VALUES (1,6);
INSERT INTO pokemon_abilities VALUES (2,1);
INSERT INTO pokemon_abilities VALUES (2,2);
INSERT INTO pokemon_abilities VALUES (3,3);
INSERT INTO pokemon_abilities VALUES (3,4);
INSERT INTO pokemon_abilities VALUES (3,5);
INSERT INTO pokemon_abilities VALUES (3,6);
INSERT INTO pokemon_abilities VALUES (4,5);
INSERT INTO pokemon_abilities VALUES (4,2);
INSERT INTO pokemon_abilities VALUES (5,7);
INSERT INTO pokemon_abilities VALUES (6,8);
INSERT INTO pokemon_abilities VALUES (7,9);
INSERT INTO pokemon_abilities VALUES (7,10);
INSERT INTO pokemon_abilities VALUES (8,10);
INSERT INTO pokemon_abilities VALUES (8,9);
INSERT INTO pokemon_abilities VALUES (8,8);
INSERT INTO pokemon_abilities VALUES (8,7);
INSERT INTO pokemon_abilities VALUES (9,5);
INSERT INTO pokemon_abilities VALUES (9,4);
INSERT INTO pokemon_abilities VALUES (10,3);
INSERT INTO pokemon_abilities VALUES (11,2);

INSERT INTO evolution (id_evolution, name, type, extra_type, evolution_level, is_enabled, id_pokemon)
VALUES (1,'Ivysaur','Grass','Poison', 16, true, 1);
INSERT INTO evolution (id_evolution, name, type, extra_type, evolution_level, is_enabled, id_pokemon)
VALUES (2,'Venusaur','Grass','Poison', 32, true, 1);
INSERT INTO evolution (id_evolution, name, type, evolution_level, is_enabled, id_pokemon)
VALUES (3,'Charmeleon','Fire', 18, true, 2);
INSERT INTO evolution (id_evolution, name, type, extra_type, evolution_level, is_enabled, id_pokemon)
VALUES (4,'Charizard','Fire','Flying', 36, true, 2);
INSERT INTO evolution (id_evolution, name, type, evolution_level, is_enabled, id_pokemon)
VALUES (5,'Wartortle','Water', 17, true, 3);
INSERT INTO evolution (id_evolution, name, type, evolution_level, is_enabled, id_pokemon)
VALUES (6,'Blastoise','Water', 34, true, 3);
INSERT INTO evolution (id_evolution, name, type, evolution_level, is_enabled, id_pokemon)
VALUES (7,'Primeape','Fighting', 24, true, 4);
INSERT INTO evolution (id_evolution, name, type, extra_type, evolution_level, is_enabled, id_pokemon)
VALUES (8,'Annihiliape','Fighting','Ghost', 40, true, 4);
INSERT INTO evolution (id_evolution, name, type, evolution_level, is_enabled, id_pokemon)
VALUES (9,'Kingler','Water', 24, true, 5);
INSERT INTO evolution (id_evolution, name, type, extra_type, evolution_level, is_enabled, id_pokemon)
VALUES (10,'Dragonair','Dragon','Flying', 30, true, 9);
INSERT INTO evolution (id_evolution, name, type, extra_type, evolution_level, is_enabled, id_pokemon)
VALUES (11,'Dragonite','Dragon','Flying', 50, true, 9);

INSERT INTO evolution_abilities VALUES (1,10);
INSERT INTO evolution_abilities VALUES (2,7);
INSERT INTO evolution_abilities VALUES (2,8);
INSERT INTO evolution_abilities VALUES (3,5);
INSERT INTO evolution_abilities VALUES (3,4);
INSERT INTO evolution_abilities VALUES (4,5);
INSERT INTO evolution_abilities VALUES (4,2);
INSERT INTO evolution_abilities VALUES (5,7);
INSERT INTO evolution_abilities VALUES (6,8);
INSERT INTO evolution_abilities VALUES (7,9);
INSERT INTO evolution_abilities VALUES (7,10);
INSERT INTO evolution_abilities VALUES (8,10);
INSERT INTO evolution_abilities VALUES (8,9);
INSERT INTO evolution_abilities VALUES (8,8);
INSERT INTO evolution_abilities VALUES (8,7);
INSERT INTO evolution_abilities VALUES (9,5);
INSERT INTO evolution_abilities VALUES (9,4);
INSERT INTO evolution_abilities VALUES (10,3);
INSERT INTO evolution_abilities VALUES (11,2);

