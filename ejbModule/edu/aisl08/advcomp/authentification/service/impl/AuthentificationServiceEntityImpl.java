package edu.aisl08.advcomp.authentification.service.impl;

import javax.inject.Inject;

import edu.aisl08.advcomp.ServiceLocator;
import edu.aisl08.advcomp.authentification.service.AuthentificationService;
import edu.aisl08.advcomp.authentification.service.UtilisateurService;

public class AuthentificationServiceEntityImpl implements AuthentificationService {
	
	@Inject
	private UtilisateurService utilisateurService;
	
	public UtilisateurService getUtilisateurService() {
		// Si dépendance non fournie, on la demande in ServiceLocator
		if(utilisateurService == null) {
			utilisateurService = ServiceLocator.getInstance().getUtilisateurService();
		}
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public AuthentificationServiceEntityImpl() {
	}

	@Override
	public Boolean authentifier(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
