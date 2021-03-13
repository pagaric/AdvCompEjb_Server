package edu.aisl08.advcomp.authentification.service.impl;

import javax.inject.Inject;

import edu.aisl08.advcomp.ServiceLocator;
import edu.aisl08.advcomp.authentification.AdvcompException;
import edu.aisl08.advcomp.authentification.dao.impl.UtilisateurDao;
import edu.aisl08.advcomp.authentification.service.UtilisateurService;
import edu.aisl08.advcomp.entity.Utilisateur;

/**
 * Implémentation Utilisateur Service utilisant un Dao 
 */
public class UtilisateurServiceImpl implements UtilisateurService {

	@Inject
	private UtilisateurDao utilisateurDao;
	
	public UtilisateurServiceImpl() {
	}
		
	public UtilisateurDao getUtilisateurDao() {
		if(utilisateurDao == null) {
			utilisateurDao =ServiceLocator.getInstance().getUtilisateurDao();
		}
		return utilisateurDao;
	}

	/**
	 * A utiliser pour fournir une implémentation pour la dépendance vers UtilisateurDao
	 * @param utilisateurDao
	 */
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	@Override
	public Utilisateur obtenirUtilisateur(String login) throws AdvcompException {
		return getUtilisateurDao().retrieve(login);
	}

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) throws AdvcompException {
		return getUtilisateurDao().create(utilisateur);
	}

	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) throws AdvcompException {
		return getUtilisateurDao().update(utilisateur);
	}

	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) throws AdvcompException{
		getUtilisateurDao().delete(utilisateur);
	}

	@Override
	public Utilisateur getNewUtilisateur() throws AdvcompException {
		return utilisateurDao.getNew();
	}

}
