package dev.api.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.time.ZonedDateTime;
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
import dev.api.entite.Departement;
import dev.api.repository.CollaborateurRepository;

@RestController
@RequestMapping("/collaborateurs")
@Transactional
@EnableGlobalMethodSecurity(securedEnabled = true)
public class DatasController {
	
	@Autowired
	CollaborateurRepository repositoryCollaborateurs;
	
	@RequestMapping(method = RequestMethod.GET,produces = "application/json")
	public List<Collaborateur> listerCollaborateurs() {
		return repositoryCollaborateurs.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,value="?departement={id_dep}",produces = "application/json")
	public List<Collaborateur> listerCollaborateursParDepartement(@PathVariable Integer id_dep) {
		return repositoryCollaborateurs.findAll().stream().filter(collaborateur->collaborateur.getDepartement().getId().equals(id_dep)).collect(Collectors.toList());
	}
	
	@RequestMapping(method = RequestMethod.GET,value=("/{matricule}"),produces = "application/json")
	public Collaborateur lireCollaborateurs(@PathVariable String matricule){
		List<Collaborateur> collab=repositoryCollaborateurs.findAll().stream().filter(collaborateur->collaborateur.getMatricule().equals(matricule)).collect(Collectors.toList());
		if(collab.size()>0) {
			return collab.get(0);
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT,produces = "application/json")
	@GetMapping("/{Matricule}")
	public Collaborateur modifieCollaborateurs(@PathVariable String matricule,String nom,String intitulePoste,Departement departement,String adresse,ZonedDateTime date,String banque) {
		Collaborateur resultat=new Collaborateur();
		if(!repositoryCollaborateurs.findByMatricule(matricule).isEmpty()) {
			resultat=repositoryCollaborateurs.findByMatricule(matricule).get(0);
			for(Parameter args:this.getClass().getDeclaredMethods()[4].getParameters()) {
				if(args==null) {
					continue;
				}
				try {
					resultat.getClass().getMethod("set"+args.getName().toUpperCase().charAt(0)+args.getName().substring(1, args.getName().length()-1), args.getType()).invoke(resultat, args);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		resultat.setMatricule(matricule);
		return resultat;
	}
	

}
