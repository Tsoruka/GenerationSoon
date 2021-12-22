package it.generationsoon.service;

import it.generationsoon.model.Regista;

public interface RegistaService {
	
	Regista findById(int id) throws ServiceException;

}
