package dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.api.entite.Departement;
import dev.api.repository.DepartementRepository;

@RestController
@RequestMapping("/departements")
@Transactional
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DepartementsController {

	@Autowired
	DepartementRepository repositoryDepartement;
	
	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	@RequestMapping(method = RequestMethod.GET,produces = "application/json")
	public List<Departement> listerDepartements() {
		List<Departement> departements=repositoryDepartement.findAll();
		return departements;
	}
	
}
