package edu.aisl08.advcomp.entity.impl;

import edu.aisl08.advcomp.Role;
import edu.aisl08.advcomp.entity.Utilisateur;

/**
 * Entité Utilisateur: un utilisateur du système AdvComp
 * @author philippe
 *
 */
public class UtilisateurImpl implements Utilisateur {
	
	/**
	 * Login de l'utilisateur
	 */
	private String login;
	/**
	 * MOt de passe de l'utilisateur
	 */
	private String password;
	/**
	 * Nom de l'utilisateur
	 */
	private String nom;
	/**
	 * Adresse postale
	 */
	private String adresse;
	/**
	 * Role (Admin ou simple Client)
	 */
	private Role role;
	
	
	public UtilisateurImpl() {
	}
	
	public UtilisateurImpl(String login, String password, String nom, String adresse, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.adresse = adresse;
		this.role = role;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getAdresse() {
		return adresse;
	}

	@Override
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public void setRole(Role role) {
		this.role = role;
	}

}
