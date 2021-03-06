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
	
	//funzionalit� 1 -> trova tutti i film in ordine decrescente
	List<Film> findAll() throws ServiceException;
	
	//funzionalit� 2 -> filtra film per genere e anno
	List<Film> filterByGenereAndAnno(String genere, int anno) throws ServiceException;
	
	//funzionalit� 3 -> trova i film per il titolo
	List<Film> findByTitolo(String titolo) throws ServiceException;
	
	List<Film> OrderByVoto() throws ServiceException;
	
	List<Film> findMarvel() throws ServiceException;
	
}
