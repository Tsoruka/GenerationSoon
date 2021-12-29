package it.generationsoon.service;

import java.sql.Connection;
import java.util.List;

import it.generationsoon.dao.DAOException;
import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;
import it.generationsoon.model.Ruolo;

public interface FilmService {
	//recuperiamo informazioni sul nostro FILM (conoscendo id) 
	//dettaglio film
	Film findById(int id) throws ServiceException;
	
	//funzionalità 1 -> trova tutti i film in ordine decrescente
	List<Film> findAll() throws ServiceException;
	
	//funzionalità 3 -> trova i film per il titolo
	List<Film> findByTitolo(String titolo) throws ServiceException;


}
