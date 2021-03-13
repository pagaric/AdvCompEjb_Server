package edu.aisl08.advcomp.core.service.impl;

import javax.inject.Inject;

import edu.aisl08.advcomp.ServiceLocator;
import edu.aisl08.advcomp.authentification.AdvcompException;
import edu.aisl08.advcomp.authentification.service.AuthentificationService;
import edu.aisl08.advcomp.authentification.service.UtilisateurService;
import edu.aisl08.advcomp.core.service.AdvCompServer;
import edu.aisl08.advcomp.core.service.AdvCompService;

public class AdvCompServerImplV2 implements AdvCompServer {

	@Inject
	private AuthentificationService authentificationService;
	@Inject
	private UtilisateurService utilisateurService;

	/**
	 * Un Provider Guice est une sorte de Factory qui fournit une nouvelle 
	 * instance par appel � get
	 */
	@Inject
	//private Provider<AdvCompService> advCompServiceProvider;
	
	public AuthentificationService getAuthentificationService() {
		if(authentificationService == null) {
			authentificationService = ServiceLocator.getInstance().getAuthentificationService();
		}
		return authentificationService;
	}

	public void setAuthentificationService(AuthentificationService authentificationService) {
		this.authentificationService = authentificationService;
	}

	public UtilisateurService getUtilisateurService() {
		if(utilisateurService == null) {
			utilisateurService = ServiceLocator.getInstance().getUtilisateurService();
		}
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	
	
	public AdvCompServerImplV2() {
	}

	@Override
	public AdvCompService connexion(String login, String password) throws AdvcompException {
		if(!getAuthentificationService().authentifier(login, password)) {
			throw new AdvcompException("Echec authentification");
		} else {
			//Utilisateur client = getUtilisateurService().obtenirUtilisateur(login);
			//AdvCompService advCompService = advCompServiceProvider.get();
			//advCompService.setClient(client);
			//return advCompService;
			return null;
		}
	}

}
