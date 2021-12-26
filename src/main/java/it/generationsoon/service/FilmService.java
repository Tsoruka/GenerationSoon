package it.generationsoon.service;

import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;
import it.generationsoon.model.Ruolo;

public interface FilmService {
	//recuperiamo informazioni sul nostro FILM (conoscendo id) 
	Film findById(int id) throws ServiceException;
	
	//Ruolo getRuolo(int id) throws ServiceException;
}
