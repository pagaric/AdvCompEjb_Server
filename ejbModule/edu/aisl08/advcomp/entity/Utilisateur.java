package edu.aisl08.advcomp.entity;

import edu.aisl08.advcomp.Role;
import fmk.persistence.Entity;

public interface Utilisateur extends Entity {

	String getLogin();

	void setLogin(String login);

	String getPassword();

	void setPassword(String password);

	String getNom();

	void setNom(String nom);

	String getAdresse();

	void setAdresse(String adresse);

	Role getRole();

	void setRole(Role role);
}
