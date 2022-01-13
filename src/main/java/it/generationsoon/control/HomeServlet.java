package it.generationsoon.control;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class HomeServlet
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmService filmService = new FilmServiceImpl();

    /**
     * Default constructor. 
     */
    public HomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//creazione di una lista di film a partire dal filmService
			//tramite metodo findAll()
			List<Film> listaFilmVoto = filmService.OrderByVoto();
			List<Film> listaFilmUscita = filmService.findAll();
			List<Film> listaFilmMarvel = filmService.findMarvel();
			
			//info relative al genere del medesimo film 
			
			//inoltro richiesta HTTP per la stampa (in una pagina web) della lista film 
			//che sono stati presi dalle info del database di riferimento 
			request.setAttribute("listaFilmUscita", listaFilmUscita);
			request.setAttribute("listaFilmVoto", listaFilmVoto);
			request.setAttribute("listaFilmMarvel", listaFilmMarvel);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.jsp");
		}

	}

}