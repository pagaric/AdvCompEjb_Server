package edu.aisl08.advcomp.core.service.impl;

import javax.inject.Inject;

import edu.aisl08.advcomp.ServiceLocator;
import edu.aisl08.advcomp.authentification.AdvcompException;
import edu.aisl08.advcomp.calcul.CalculException;
import edu.aisl08.advcomp.calcul.service.CalculateurService;
import edu.aisl08.advcomp.core.service.AdvCompService;
import edu.aisl08.advcomp.entity.Utilisateur;
import edu.aisl08.advcomp.facturation.service.FacturationService;

/**
 * Service Statefull => une instance par utilisateur
 * @author philippe
 *
 */
public class AdvCompServiceImpl implements AdvCompService {

	private Utilisateur client;

	public void setClient(Utilisateur client) {
		this.client = client;
	}

	@Inject
	private CalculateurService calculateurService;
	
	public CalculateurService getCalculateurService() {
		if(calculateurService == null) {
			calculateurService = ServiceLocator.getInstance().getCalculateurService();
		}
		return calculateurService;
	}

	public void setCalculateurService(CalculateurService calculateurService) {
		this.calculateurService = calculateurService;
	}

	@Inject
	private FacturationService facturationService;
	
	public FacturationService getFacturationService() {
		if(facturationService == null) {
			facturationService = ServiceLocator.getInstance().getFacturationService();
		}
		return facturationService;
	}

	public void setFacturationService(FacturationService facturationService) {
		this.facturationService = facturationService;
	}


	public AdvCompServiceImpl() {
	}

	public AdvCompServiceImpl(Utilisateur client) {
		this.client = client;
	}

	@Override
	public Double faireOperationBasique(Double facteur1, Double facteur2, String operateur) throws AdvcompException {
		
		try {
			Double resultat;
			
			String descriptionOperation = facteur1 + " " + operateur + " " + facteur2;
			
			// Calcul
			switch (operateur) {
			case "+":
				resultat = getCalculateurService().additionner(facteur1, facteur2);
				break;
			case "-":
				resultat = getCalculateurService().soustraire(facteur1, facteur2);
				break;
			case "*":
				resultat = getCalculateurService().multiplier(facteur1, facteur2);
				break;
			case "/":
				resultat = getCalculateurService().diviser(facteur1, facteur2);
				break;
			default:
				throw new AdvcompException("Opérateur " + operateur + " Non géré.");
			}
			
			// Historisation
			getFacturationService().historiserOperation(client, descriptionOperation);
			
			return resultat;
		
		} catch (CalculException e) {
			e.printStackTrace();
			throw new AdvcompException("Echec Calcul", e);
			
		} catch (AdvcompException e) {
			throw e;
		}
	}

}
