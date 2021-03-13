package edu.aisl08.advcomp.facturation.entity;

import java.util.Date;

import edu.aisl08.advcomp.entity.Utilisateur;
import fmk.persistence.Entity;

public interface Facture extends Entity {

	public Utilisateur getUtilisateur();
	
	public void setUtilisateur(Utilisateur utilisateur);	
	
	public String getNumero();
	
	public void setNumero(String numero);
	
	public Date getDate();
	
	public void setDate(Date date);
	
	public double getMontant();
	
	public void setMontant(double montant);
	
	public boolean isSoldee();
	
	public void setSoldee(boolean soldee);
}
