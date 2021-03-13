package edu.aisl08.advcomp.core.service;

import edu.aisl08.advcomp.entity.Utilisateur;

@FunctionalInterface
public interface AdvCompServiceFactory {
	
	/**
	 * Création du service
	 * @param client
	 * @return
	 */
	public AdvCompService createAdvCompService(Utilisateur client);

}
