package fr.efrei.pokemon.models;

import fr.efrei.pokemon.constants.TypePokemon;
import jakarta.persistence.*;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) // AUTO INCREMENT
	private String id;

	private String name;

	private int level;

	@Enumerated(EnumType.STRING)
	private TypePokemon type; // SI mon pokemon est type feu -> Type == "FEU"

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public TypePokemon getType() {
		return type;
	}

	public void setType(TypePokemon type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
