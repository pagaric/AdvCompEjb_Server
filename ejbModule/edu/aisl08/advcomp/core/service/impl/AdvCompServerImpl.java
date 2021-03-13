package edu.aisl08.advcomp.core.service.impl;

import javax.inject.Inject;

import edu.aisl08.advcomp.ServiceLocator;
import edu.aisl08.advcomp.authentification.AdvcompException;
import edu.aisl08.advcomp.authentification.service.AuthentificationService;
import edu.aisl08.advcomp.authentification.service.UtilisateurService;
import edu.aisl08.advcomp.core.service.AdvCompServer;
import edu.aisl08.advcomp.core.service.AdvCompService;
import edu.aisl08.advcomp.core.service.AdvCompServiceFactory;
import edu.aisl08.advcomp.entity.Utilisateur;

public class AdvCompServerImpl implements AdvCompServer {

	@Inject
	private AuthentificationService authentificationService;
	@Inject
	private UtilisateurService utilisateurService;
	
	/**
	 * Factory pour crer les instances à la connexion d'un client
	 */
	private AdvCompServiceFactory advCompServiceFactory;
	
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

	
	public AdvCompServiceFactory getAdvCompServiceFactory() {
		return advCompServiceFactory;
	}

	@Inject
	public void setAdvCompServiceFactory(AdvCompServiceFactory advCompServiceFactory) {
		this.advCompServiceFactory = advCompServiceFactory;
	}

	public AdvCompServerImpl() {
	}

	@Override
	public AdvCompService connexion(String login, String password) throws AdvcompException {
		if(!getAuthentificationService().authentifier(login, password)) {
			throw new AdvcompException("Echec authentification");
		} else {
			Utilisateur client = getUtilisateurService().obtenirUtilisateur(login);
			return getAdvCompServiceFactory().createAdvCompService(client);		
		}
	}

}
