package it.generationsoon.control;

import it.generationsoon.model.Attore;
import it.generationsoon.model.Film;
import it.generationsoon.model.Genere;
import it.generationsoon.model.Regista;
import it.generationsoon.model.Ruolo;
import it.generationsoon.model.Utente;
import it.generationsoon.model.VotoUtente;
import it.generationsoon.service.AttoreService;
import it.generationsoon.service.FilmService;
import it.generationsoon.service.GenereService;
import it.generationsoon.service.RegistaService;
import it.generationsoon.service.RuoloService;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.UtenteService;
import it.generationsoon.service.VotoUtenteService;
import it.generationsoon.service.impl.AttoreServiceImpl;
import it.generationsoon.service.impl.FilmServiceImpl;
import it.generationsoon.service.impl.GenereServiceImpl;
import it.generationsoon.service.impl.RegistaServiceImpl;
import it.generationsoon.service.impl.RuoloServiceImpl;
import it.generationsoon.service.impl.UtenteServiceImpl;
import it.generationsoon.service.impl.VotoUtenteServiceImpl;

public class Main {

	private static Attore attore = new Attore();
	private static AttoreService attoreService = new AttoreServiceImpl();
	private static FilmService filmService = new FilmServiceImpl();
	private static GenereService genereService = new GenereServiceImpl();
	private static RegistaService registaService = new RegistaServiceImpl();
	private static RuoloService ruoloService = new RuoloServiceImpl();
	private static UtenteService utenteService = new UtenteServiceImpl();
	private static VotoUtenteService votoUtenteService = new VotoUtenteServiceImpl();

	public static void main(String[] args) {
//		findById(3);
//		filmFindById(2);
//		// genereFindById(17);
//		// registaFindById(2);
//		ruoloFindById(1);
		// utenteFindById(1);
		// saveUtente();
		// utenteFindByUser("AnnaB");
		// findVotoById(1);
		
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
			utente.setUsername("AnnaB");
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

	private static void genereFindById(int id) {
		try {
			Genere genere = genereService.findById(id);
			System.out.println(genere);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void registaFindById(int id) {
		try {
			Regista regista = registaService.findById(id);
			System.out.println(regista);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void ruoloFindById(int id) {
		try {
			Ruolo ruolo = ruoloService.findById(id);
			System.out.println(ruolo);
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
