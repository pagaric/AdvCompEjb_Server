package edu.aisl08.advcomp.facturation.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import edu.aisl08.advcomp.ServiceLocator;
import edu.aisl08.advcomp.authentification.AdvcompException;
import edu.aisl08.advcomp.entity.Utilisateur;
import edu.aisl08.advcomp.facturation.dao.FactureDao;
import edu.aisl08.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl08.advcomp.facturation.entity.Facture;
import edu.aisl08.advcomp.facturation.entity.HistoriqueOperation;
import edu.aisl08.advcomp.facturation.service.FacturationService;

public class FacturationServiceImpl implements FacturationService {

	@Inject
	private HistoriqueOperationDao historiqueOperationDao;

	public HistoriqueOperationDao getHistoriqueOperationDao() {
		if (historiqueOperationDao == null) {
			// historiqueOperationDao = (HistoriqueOperationDao)
			// ServiceLocatorDynamique.getInstance().getService(HistoriqueOperationDao.class.getName());
			// historiqueOperationDao =
			// ServiceLocatorDynamiqueV2.getInstance().getService(HistoriqueOperationDao.class);
			historiqueOperationDao = ServiceLocator.getInstance().getHistoriqueOperationDao();
		}
		return historiqueOperationDao;
	}

	public void setHistoriqueOperationDao(HistoriqueOperationDao historiqueOperationDao) {
		this.historiqueOperationDao = historiqueOperationDao;
	}

	@Inject
	private FactureDao factureDao;

	public FactureDao getFactureDao() {
		if (factureDao == null) {
			factureDao = ServiceLocator.getInstance().getFactureDao();
		}
		return factureDao;
	}

	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}

	public FacturationServiceImpl() {
	}

	@Override
	public void historiserOperation(Utilisateur client, String descriptionOperation) throws AdvcompException {
		System.out.println("Historisation " + client.getNom() + " ==> " + descriptionOperation);

		HistoriqueOperation historiqueOperation = getHistoriqueOperationDao().getNew();
		historiqueOperation.setDate(new Date());
		historiqueOperation.setUtilisateur(client);
		historiqueOperation.setDescription(descriptionOperation);
		// pas encore facturée
		historiqueOperation.setFacture(null);
		getHistoriqueOperationDao().create(historiqueOperation);

	}

	@Override
	public void facturer(Date dateDebut, Date datefin) throws AdvcompException {
		List<HistoriqueOperation> operationsAFacturer = historiqueOperationDao.getOperationAFacturer(dateDebut,
				datefin);

		Iterator<HistoriqueOperation> iterateur = operationsAFacturer.iterator();

		HistoriqueOperation operationEnCours = null;
		// check pour rentrer dans la boucle (positionné sur le premier)
		if (iterateur.hasNext()) {
			operationEnCours = iterateur.next();
		}

		// iterer sur les operations
		while (iterateur.hasNext()) {

			// tant qu'on est sur le même utilisateur on créé une facture et on l'associe a
			// l'operation
			Utilisateur user = operationEnCours.getUtilisateur();

			Facture facture = factureDao.getNew();
			facture.setUtilisateur(user);
			facture.setDate(new Date());
			facture.setSoldee(false);
			facture.setMontant(0d);
			factureDao.create(facture);

			String header = "Facture :\n";

			while (iterateur.hasNext() && operationEnCours.getUtilisateur().equals(user)) {
				facture.setMontant(facture.getMontant() + 1.20d);
				operationEnCours.setFacture(facture);
				historiqueOperationDao.update(operationEnCours);
				// On passe à l'iteration suivante
				operationEnCours = iterateur.next();
			}
			factureDao.update(facture);
		}

	}

	@Override
	public void reglerFacture(String numeroFacture, String rib) throws AdvcompException {
	}

	@Override
	public Facture obtenirFacture(String numeroFacture) {
		return null;
	}

}
