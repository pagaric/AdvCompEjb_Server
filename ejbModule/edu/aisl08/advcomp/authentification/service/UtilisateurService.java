package edu.aisl08.advcomp.authentification.service;

import edu.aisl08.advcomp.authentification.AdvcompException;
import edu.aisl08.advcomp.entity.Utilisateur;

/**
 * Service dédié à  la gestion des utilisateurs
 * @author philippe
 *
 */
public interface UtilisateurService {

	/**
	 * Retourne un utilisateur d'après son login 
	 * et null si aucun utilisateur avec le login existe
	 * @param login
	 * @return
	 */
	public Utilisateur obtenirUtilisateur(String login) throws AdvcompException; 
	
	/**
	 * Crée un nouvel utilisateur
	 * @param utilisateur
	 * @return
	 */
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) throws AdvcompException;
	
	/**
	 * Met à jour l'utilisateur
	 * @param utilisateur
	 * @return
	 */
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws AdvcompException;
	
	/**
	 * Supprime l'utilisateur
	 * @param utilisateur
	 */
	public void supprimerUtilisateur(Utilisateur utilisateur) throws AdvcompException;

	/**
	 * retourne une nouvelle instance d'utilisateur
	 * @return
	 */
	public Utilisateur getNewUtilisateur() throws AdvcompException;
}
