package it.generationsoon.service;

import it.generationsoon.model.Utente;

public interface UtenteService {
	
	void save(Utente utente) throws ServiceException;

	Utente findById(int id) throws ServiceException;

	Utente findByUsername(String username) throws ServiceException;
}
