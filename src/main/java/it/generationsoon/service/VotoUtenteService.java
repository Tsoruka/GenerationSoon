package it.generationsoon.service;


import it.generationsoon.model.VotoUtente;

public interface VotoUtenteService {
	
	VotoUtente findById(int id) throws ServiceException;
	
	void update(VotoUtente votoUtente) throws ServiceException;
	
	int votoUtenteId(int utente_id, int film_id) throws ServiceException;

}
