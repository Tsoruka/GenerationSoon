package it.generationsoon.service;

import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;

public interface FilmService {
	
	Film findById(int id) throws ServiceException;

	Genere findGenereById(int genereId) throws ServiceException;
	
	
	
}
