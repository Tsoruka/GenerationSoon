package it.generationsoon.control;

import java.util.List;

import it.generationsoon.dao.FilmDAO;
import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Ruolo;
import it.generationsoon.model.Utente;
import it.generationsoon.model.VotoUtenteFilm;
import it.generationsoon.service.AttoreService;
import it.generationsoon.service.FilmService;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.UtenteService;
import it.generationsoon.service.VotoUtenteFilmService;
import it.generationsoon.service.impl.AttoreServiceImpl;
import it.generationsoon.service.impl.FilmServiceImpl;
import it.generationsoon.service.impl.UtenteServiceImpl;
import it.generationsoon.service.impl.VotoUtenteFilmServiceImpl;

public class Main {

	// private static Attore attore = new Attore();
	private static AttoreService attoreService = new AttoreServiceImpl();
	private static FilmService filmService = new FilmServiceImpl();

	private static UtenteService utenteService = new UtenteServiceImpl();
	private static VotoUtenteFilmService votoUtenteFilmService = new VotoUtenteFilmServiceImpl();

	public static void main(String[] args) {
		// findById(3);
		// filmFindById(3);
		// genereFindById(17);
		// registaFindById(2);
		// utenteFindById(1);
		// saveUtente();
		// utenteFindByUser("AnnaB2");
		// findVotoById(1)
		// voto_utente(1,1);
		// votoUpdate();
//getGenereFindById(3);
//getRegistaFindById(3);
		// filtro("z", 0);
		controlloVotoUtente();
	}
	
	private static void saveVotoUtente() {
		try {			
			votoUtenteFilmService.save(2,3,7);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}
	private static void controlloVotoUtente() {
		try {			
			System.out.print("main: " + votoUtenteFilmService.votato(2,5));
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	private static void updateVotoUtente() {
		try {			
			votoUtenteFilmService.update(2,5,9);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void filtro(String genere, int anno) {

		try {
			List<Film> lista = filmService.filterByGenereAndAnno(genere, anno);
			System.out.println(lista);

		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	// GET GENERE DA FILM SERVICE
//		private static void getRegistaFindById(int filmId) {
//			try {
//				Regista regista = filmService.findRegistaByFilmId(filmId);
//				//System.out.println(regista);
//				System.out.println("Regista: " + regista.getNome() + " " + regista.getCognome());
//			} catch (ServiceException e) {
//				System.err.println(e.getMessage());
//			}
//		}
//	
	// GET GENERE DA FILM SERVICE
//	private static void getGenereFindById(int filmId) {
//		try {
//			Genere genere = filmService.findGenereByFilmId(filmId);
//			System.out.println(genere);
//		} catch (ServiceException e) {
//			System.err.println(e.getMessage());
//		}
//	}
	// Utente utente;
	




	private static void utenteFindByUser(String username) {
		try {
			Utente utente = utenteService.findByUsername(username);
			System.out.println(utente);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void saveUtente() {
		try {
			Utente utente = new Utente();
			utente.setNome("Anna");
			utente.setCognome("Bonomo");
			utente.setEmail("annaB@gmail.com");
			utente.setUsername("AnnaB2");
			utente.setPassword("123");
			utenteService.save(utente);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void findById(int id) {
		try {
			Attore attore = attoreService.findById(id);
			System.out.println(attore);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void filmFindById(int id) {
		try {
			Film film = filmService.findById(id);
			System.out.println(film);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void utenteFindById(int id) {
		try {
			Utente utente = utenteService.findById(id);
			System.out.println(utente);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

}
