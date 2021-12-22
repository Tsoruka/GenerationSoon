package it.generationsoon.service;

import it.generationsoon.model.Genere;

public interface GenereService {
	
	Genere findById(int id) throws ServiceException;

}
