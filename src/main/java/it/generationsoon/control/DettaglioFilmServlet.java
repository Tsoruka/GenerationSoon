package it.generationsoon.control;

import java.io.IOException;

import it.generationsoon.model.Film;
import it.generationsoon.service.FilmService;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.impl.FilmServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DettaglioFilmServlet
 */
@WebServlet("/dettaglio-film")
public class DettaglioFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//mi serve per richiamare le funzioni di FilmService
	//all'interno della Servlet di dettaglio di quello 
	//specifico film - selezionato dall'utente
	private FilmService filmService = new FilmServiceImpl();
	
	// ------------------------------------------------  //
	//TODO: TRASPORTO DI id relativo al film selezionato 
	// ------------------------------------------------  //
	
    /**
     * Default constructor. 
     */
    public DettaglioFilmServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filmId = 3;
		try {
			//creazione di un oggetto tipo film a partire dal filmService
			//tramite metodo findById(fimId)
			Film film = filmService.findById(filmId);
			//info relative al genere del medesimo film 
			
			//inoltro informazioni relative al film 
			request.setAttribute("film", film);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("film_info.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.html");
		}
	}

}
