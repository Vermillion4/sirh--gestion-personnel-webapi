package dev.api.entite;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


@Entity
public class Collaborateur implements Serializable {

	private static final long serialVersionUID = -7788619185233712L;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue
	private Integer id;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String intitulePoste;
	
	/**
	 * @return the intitulePoste
	 */
	public String getIntitulePoste() {
		return intitulePoste;
	}

	/**
	 * @param intitulePoste the intitulePoste to set
	 */
	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}
	
	@ManyToOne
	private Departement departement;

	/**
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	/**
	 * Le matricule.
	 */
	private String matricule;
	
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	/**
	 * Le nom.
	 */
	private String nom;
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Le prenom
	 */
	private String prenom;
	
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Le titre.
	 */
	private String titre;
	
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	private LocalDate dateDeNaissance;
	
	/**
	 * @return the dateDeNaisance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**
	 * 
	 * @param dateDeNaisance the dateDeNaisance to set
	*/
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	
	private String adresse;

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	private String numeroDeSecuriteSociale;
	
	/**
	 * @return the numeroDeSecuriteSociale
	 */
	public String getNumeroDeSecuriteSociale() {
		return numeroDeSecuriteSociale;
	}

	/**
	 * @param numeroDeSecuriteSociale the numeroDeSecuriteSociale to set
	 */
	public void setNumeroDeSecuriteSociale(String numeroDeSecuriteSociale) {
		this.numeroDeSecuriteSociale = numeroDeSecuriteSociale;
	}

	private String emailPro;
	
	/**
	 * @return the emailPro
	 */
	public String getEmailPro() {
		return emailPro;
	}

	/**
	 * @param emailPro the emailPro to set
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	private String photo;
	
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@JsonSerialize(using=DateSerializer.class)
	private ZonedDateTime dateHeureCreation;

	
	/**
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	
	 /**
	  * @param dateHeureCreation the dateHeureCreation to set
	  */
	 public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	
	private boolean actif;
	
	/**
	 * @return the actif
	 */
	public boolean isActif() {
		return actif;
	}

	/**
	 * @param actif the actif to set
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	private String banque;
	
	/**
	 * @return the banque
	 */
	public String getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(String banque) {
		this.banque = banque;
	}
	
	private String bin;
	
	/**
	 * @return the bin
	 */
	public String getBin() {
		return bin;
	}

	/**
	 * @param bin the bin to set
	 */
	public void setBin(String bin) {
		this.bin = bin;
	}
	
	private String iban;

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * Un constructeur avec des valeurs par défauts.
	 * Attention, il devra n'être utilisé qu'avec des Setters des autres éléments.
	 */
	public Collaborateur(){
		this.photo="resources/fictive.jpg";
		this.actif=true;
	}
	
}
