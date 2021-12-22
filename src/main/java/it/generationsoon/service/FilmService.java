package it.generationsoon.service;

import it.generationsoon.model.Film;

public interface FilmService {
	
	Film findById(int id) throws ServiceException;

}
