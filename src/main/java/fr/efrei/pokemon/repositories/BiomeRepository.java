package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Biome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiomeRepository extends JpaRepository<Biome, String> { }
