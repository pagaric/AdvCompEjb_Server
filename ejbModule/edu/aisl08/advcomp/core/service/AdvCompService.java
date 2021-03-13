package edu.aisl08.advcomp.core.service;

import edu.aisl08.advcomp.authentification.AdvcompException;

/**
 * Service pour les client utilisateur d'AdvComp 
 *
 */
public interface AdvCompService {

	/**
	 * Réalise un calcul basique en utilisant AdvComp
	 * 
	 * @param facteur1
	 * @param facteur2
	 * @param operateur
	 * @return
	 * @throws AdvcompException
	 */
	public Double faireOperationBasique(Double facteur1, Double facteur2, String operateur) throws AdvcompException;
}
