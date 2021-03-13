package edu.aisl08.advcomp.calcul.service.impl;

import edu.aisl08.advcomp.calcul.CalculException;
import edu.aisl08.advcomp.calcul.service.CalculateurService;

/**
 * Implémentation débile du calculateur
 * @author philippe
 *
 */
public class CalculateurDebile implements CalculateurService {

	@Override
	public Double additionner(Double facteur1, Double facteur2) throws CalculException {
		return 12d;
	}

	@Override
	public Double soustraire(Double facteur1, Double facteur2) throws CalculException {
		return 44d;
	}

	@Override
	public Double multiplier(Double facteur1, Double facteur2) throws CalculException {
		return 66d;
	}

	@Override
	public Double diviser(Double facteur1, Double facteur2) throws CalculException {
		return 12d;
	}

}
