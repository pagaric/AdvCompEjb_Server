package edu.aisl08.advcomp.calcul.service.impl;

import edu.aisl08.advcomp.calcul.CalculException;
import edu.aisl08.advcomp.calcul.service.CalculateurService;

/**
 * Implémentation du service de calcul
 * @author philippe
 *
 */
public class CalculateurServiceImpl implements CalculateurService {

	public CalculateurServiceImpl() {
	}

	@Override
	public Double additionner(Double facteur1, Double facteur2) throws CalculException {
		checkFacteurs(facteur1, facteur2);
		try {
			return facteur1 + facteur2;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CalculException("Echec Addition", e);
		}
	}

	@Override
	public Double soustraire(Double facteur1, Double facteur2) throws CalculException {
		checkFacteurs(facteur1, facteur2);
		return facteur1 - facteur2;
	}

	@Override
	public Double multiplier(Double facteur1, Double facteur2) throws CalculException {
		checkFacteurs(facteur1, facteur2);
		return facteur1 * facteur2;
	}

	@Override
	public Double diviser(Double facteur1, Double facteur2) throws CalculException {
		checkFacteurs(facteur1, facteur2);
		if (facteur2 == 0) {
			throw new CalculException("Division par Zero interdite");
		}
		return facteur1 / facteur2;
	}
	
	private void checkFacteurs(Double facteur1, Double facteur2) throws CalculException {
		if (facteur1 == null || facteur2 == null) {
			throw new CalculException("Facteur Null");
		}
	}

}
