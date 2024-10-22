package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.TypeBiome;
import jakarta.persistence.*;
import fr.efrei.pokemon.models.Pokemon;

import java.util.ArrayList;

@Entity
public class Biome {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) // AUTO INCREMENT
	private String id;

	private String name;

	//	public ArrayList<String> getPokemonList() {
	//		return pokemonList;
	//	}

	//	@ElementCollection
	//	private ArrayList<String> pokemonList;

	@Enumerated(EnumType.STRING)
	private TypeBiome type; // SI mon biome est type plaine -> Type == "PLAINE"

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeBiome getType() {
		return type;
	}

	public void setType(TypeBiome type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
