package it.generationsoon.service;

import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;

public interface FilmService {
	//recuperiamo informazioni sul nostro FILM (conoscendo id) 
	Film findById(int id) throws ServiceException;
	//recuperiamo il GENERE relativo al film, dato id del film
	Genere findGenereByFilmId(int filmId) throws ServiceException;
	//recuperiamo info REGISTA relativo al film, dato id del film 
	Regista findRegistaByFilmId(int filmId) throws ServiceException;
}
