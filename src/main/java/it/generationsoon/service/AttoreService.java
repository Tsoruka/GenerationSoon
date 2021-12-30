package it.generationsoon.service;

import java.util.List;

import it.generationsoon.model.Attore;


public interface AttoreService {
	
	Attore findById(int id) throws ServiceException;
	
	List<Attore> findAll() throws ServiceException;

}
