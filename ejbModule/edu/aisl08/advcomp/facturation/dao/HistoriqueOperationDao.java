package edu.aisl08.advcomp.facturation.dao;

import java.util.Date;
import java.util.List;

import edu.aisl08.advcomp.facturation.entity.HistoriqueOperation;
import fmk.persistence.EntityDao;

public interface HistoriqueOperationDao extends EntityDao<HistoriqueOperation, Long> {

	List<HistoriqueOperation> getOperationAFacturer(Date dateDebut, Date datefin);
}
