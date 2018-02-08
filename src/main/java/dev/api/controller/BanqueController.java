package dev.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Collaborateur;
import dev.api.repository.CollaborateurRepository;

@RestController
@RequestMapping("/collaborateurs/*/banque")
@Transactional
@EnableGlobalMethodSecurity(securedEnabled = true)
public class BanqueController {
	
	@Autowired
	CollaborateurRepository repositoryCollaborateurs;
	
	@RequestMapping(method = RequestMethod.GET,produces = "application/json")
	@GetMapping("/{Matricule}/banque/")
	public String lireBanque(@PathVariable String matricule) {
		List<Collaborateur> banque=repositoryCollaborateurs.findAll().stream().filter(collaborateur->collaborateur.getMatricule().equals(matricule)).collect(Collectors.toList());
		if(banque.size()>1) {
			return banque.get(0).getBanque();
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT,produces = "application/json")
	@GetMapping("/{Matricule}/banque/")
	public String modifieBanque(@PathVariable String matricule,String nom) {
		if(!repositoryCollaborateurs.findByMatricule(matricule).isEmpty()) {
			repositoryCollaborateurs.findByMatricule(matricule).get(0).setBanque(nom);
		}
		return nom;
	}
	
}
