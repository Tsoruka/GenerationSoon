package it.generationsoon.service;

import it.generationsoon.model.Ruolo;

public interface RuoloService {
	
	Ruolo findById(int id) throws ServiceException;

}
