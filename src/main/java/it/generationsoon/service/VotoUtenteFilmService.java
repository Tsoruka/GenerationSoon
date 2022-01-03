package it.generationsoon.service;

public interface VotoUtenteFilmService {
	
	
	void update(int filmId, int utenteId, int voto) throws ServiceException;
	
	void save(int filmId, int utenteId, int voto) throws ServiceException;
	
	//controllo se la casella voto è riempita - scelta tra save/update voto utente
	int votato(int filmId, int utenteId) throws ServiceException;
}
