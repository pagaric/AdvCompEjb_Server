package edu.aisl08.advcomp.authentification.service;

/**
 * Service d'authentification
 * @author philippe
 *
 */
public interface AuthentificationService {

	/**
	 * Authentification d'un utilisateur.
	 * 
	 * @param login
	 * @param password
	 * @return boolean
	 */
	public Boolean authentifier(String login, String password);
}
