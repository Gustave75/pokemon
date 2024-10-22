package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Biome;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.services.BiomeService;
import fr.efrei.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/biomes")
public class BiomeController {

	private final BiomeService service;

	@Autowired
	public BiomeController(BiomeService service) {
		this.service = service;
	}

	// GET
	@GetMapping
	public ResponseEntity<List<Biome>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Biome> findById(@PathVariable String id) {
		Biome biome = service.findById(id);
		if (biome == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(biome, HttpStatus.OK);
	}

	// POST
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Biome biome) {
//		ArrayList<String> pn = biome.getPokemonList();



		service.save(biome);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// PUT
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Biome biome) {
		Biome biomeAModifier = service.findById(id);
		if (biomeAModifier == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.update(id, biome);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		Biome biome = service.findById(id);
		if(biome == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
