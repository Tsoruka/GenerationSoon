package it.generationsoon.control;

import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Ruolo;
import it.generationsoon.model.Utente;
import it.generationsoon.model.VotoUtente;
import it.generationsoon.service.AttoreService;
import it.generationsoon.service.FilmService;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.UtenteService;
import it.generationsoon.service.VotoUtenteService;
import it.generationsoon.service.impl.AttoreServiceImpl;
import it.generationsoon.service.impl.FilmServiceImpl;
import it.generationsoon.service.impl.UtenteServiceImpl;
import it.generationsoon.service.impl.VotoUtenteServiceImpl;

public class Main {

	//private static Attore attore = new Attore();
	private static AttoreService attoreService = new AttoreServiceImpl();
	private static FilmService filmService = new FilmServiceImpl();
	
	private static UtenteService utenteService = new UtenteServiceImpl();
	private static VotoUtenteService votoUtenteService = new VotoUtenteServiceImpl();
	

	public static void main(String[] args) {
		//findById(3);
		filmFindById(3);
 //genereFindById(17);
//		// registaFindById(2);

		 //utenteFindById(1);
		 //saveUtente();
		// utenteFindByUser("AnnaB");
		// findVotoById(1)
		// voto_utente(1,1);
		//votoUpdate();
//getGenereFindById(3);
//getRegistaFindById(3);
	}
	


	//GET GENERE DA FILM SERVICE 
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
	//GET GENERE DA FILM SERVICE 
//	private static void getGenereFindById(int filmId) {
//		try {
//			Genere genere = filmService.findGenereByFilmId(filmId);
//			System.out.println(genere);
//		} catch (ServiceException e) {
//			System.err.println(e.getMessage());
//		}
//	}
		//Utente utente;
		private static void votoUpdate() {
		try {
			Utente utente;
			Film film = filmService.findById(1);
			utente = utenteService.findById(1);
			VotoUtente votou = new VotoUtente();
			votou.setFilm(film);
			votou.setUtente(utente);
			votou.setVoto(4);
			votoUtenteService.update(votou);
			System.out.println(votou.toString());
		} catch (ServiceException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pippof.setUtente(utente);
		//pippof.setUtente(utenteFindByUser("AnnaB"));
		//votoUtenteService.update( );
	}

		private static void voto_utente(int utenteId, int FIlmId) {
			try {
		int pippoIdTopGun = votoUtenteService.votoUtenteId(1, 1);
		System.out.println(pippoIdTopGun);
			} catch (ServiceException e) {
				System.err.println(e.getMessage());
			}
			}
	
	
	
	private static void findVotoById(int id) {
		try {
			VotoUtente votoUtente = votoUtenteService.findById(id);
			System.out.println(votoUtente);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
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

