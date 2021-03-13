package edu.aisl08.advcomp.authentification.service.impl;

import edu.aisl08.advcomp.authentification.service.AuthentificationService;

public class AuthentificationServiceStrict implements AuthentificationService {

	@Override
	public Boolean authentifier(String login, String password) {
		return "tutu".equals(login);
	}

}
