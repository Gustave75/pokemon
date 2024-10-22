package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Biome;
import fr.efrei.pokemon.repositories.BiomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiomeService {

	private final BiomeRepository biomeRepository;

	@Autowired
	public BiomeService(BiomeRepository biomeRepository) {
		this.biomeRepository = biomeRepository;
	}

	// Trajet de la donnée
	// Base de données -> Entité -> Repository -> Service -> Controller
	public List<Biome> findAll() {
		// SELECT * FROM biome;
		return biomeRepository.findAll();
	}

	public Biome findById(String id) {
		// Optional : soit l'objet soit null
		// SELECT * FROM biome WHERE id = :id
		return biomeRepository.findById(id).orElse(null);
	}

	// Trajet de la donnée
	// Controller -> Service -> Repository -> Entité -> BDD
	public void save(Biome biome) {
		// INSERT INTO biome VALUES (:name, :type);
		System.out.printf(biome.toString());
		biomeRepository.save(biome);
	}

	public void delete(String id) {
		// DELETE FROM biome WHERE id = :id
		biomeRepository.deleteById(id);
	}

	public void update(String id, Biome biomeBody) {
		Biome biomeAModifier = findById(id);
		biomeAModifier.setType(biomeBody.getType());
		biomeAModifier.setName(biomeBody.getName());
		biomeRepository.save(biomeAModifier);
	}

	public void partialUpdate(String id, Biome biomeBody) {
		Biome biomeAModifier = findById(id);
		if(biomeBody.getType() != null) {
			biomeAModifier.setType(biomeBody.getType());
		}
		if(biomeBody.getName() != null) {
			biomeAModifier.setName(biomeBody.getName());
		}
		biomeRepository.save(biomeAModifier);
	}
}
