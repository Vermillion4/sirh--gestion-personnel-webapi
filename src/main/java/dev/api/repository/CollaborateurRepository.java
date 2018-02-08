package dev.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.api.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {
	
	public List<Collaborateur> findByMatricule(String matricule);
}
