package edu.aisl08.advcomp;

import edu.aisl08.advcomp.authentification.dao.impl.UtilisateurDao;
import edu.aisl08.advcomp.authentification.service.AuthentificationService;
import edu.aisl08.advcomp.authentification.service.UtilisateurService;
import edu.aisl08.advcomp.calcul.service.CalculateurService;
import edu.aisl08.advcomp.core.service.AdvCompServer;
import edu.aisl08.advcomp.facturation.dao.FactureDao;
import edu.aisl08.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl08.advcomp.facturation.service.FacturationService;

/**
 * ServiceLocator de AdvComp
 * 
 * Singleton qui enregistre et fournit toutes les instances de services nécessaires
 * à l'application AdvComp
 * @author philippe
 *
 */
public class ServiceLocator {

	/**
	 * Le singleton
	 */
	private static ServiceLocator instance;

	/**
	 * L'accesseur au singleton
	 * 
	 * @return
	 */
	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	private AdvCompServer advCompServer;
	private FactureDao factureDao;
	private HistoriqueOperationDao historiqueOperationDao;
	private FacturationService facturationService;
	private UtilisateurDao utilisateurDao;
	private AuthentificationService authentificationService;
	private CalculateurService calculateurService;
	private UtilisateurService utilisateurService;

	public AdvCompServer getAdvCompServer() {
		return advCompServer;
	}

	public void setAdvCompServer(AdvCompServer advCompServer) {
		this.advCompServer = advCompServer;
	}

	public FactureDao getFactureDao() {
		return factureDao;
	}

	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}

	public HistoriqueOperationDao getHistoriqueOperationDao() {
		return historiqueOperationDao;
	}

	public void setHistoriqueOperationDao(HistoriqueOperationDao historiqueOperationDao) {
		this.historiqueOperationDao = historiqueOperationDao;
	}

	public FacturationService getFacturationService() {
		return facturationService;
	}

	public void setFacturationService(FacturationService facturationService) {
		this.facturationService = facturationService;
	}

	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}

	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	public AuthentificationService getAuthentificationService() {
		return authentificationService;
	}

	public void setAuthentificationService(AuthentificationService authentificationService) {
		this.authentificationService = authentificationService;
	}

	public CalculateurService getCalculateurService() {
		return calculateurService;
	}

	public void setCalculateurService(CalculateurService calculateurService) {
		this.calculateurService = calculateurService;
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
}
