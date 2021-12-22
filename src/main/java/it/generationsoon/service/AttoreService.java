package it.generationsoon.service;

import it.generationsoon.model.Attore;


public interface AttoreService {
	
	Attore findById(int id) throws ServiceException;

}
