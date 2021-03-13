package edu.aisl08.advcomp.core.service;

import edu.aisl08.advcomp.authentification.AdvcompException;

/**
 * Serveur fournisseur de service AdvCompService aux clients authentifiés
 * @author philippe
 *
 */
public interface AdvCompServer {

	/**
	 * Traite la demande de connexion d'un client et lui retourne un {@link AdvCompService} si l'authentification a abouti
	 * dans les autres cas une {@link AdvcompException} est levée.
	 * 
	 * @param login
	 * @param password
	 * @return
	 * @throws AdvcompException
	 */
	public AdvCompService connexion(String login, String password) throws AdvcompException;
}
