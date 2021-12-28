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
 * Servlet implementation class OrdinaFilmPerNomeServlet
 */
@WebServlet("/Ordina-Film-Per-Nome")
public class OrdinaFilmPerNomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private FilmService filmService = new FilmServiceImpl();
    /**
     * Default constructor. 
     */
    public OrdinaFilmPerNomeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//creazione di un oggetto tipo film a partire dal filmService
			//tramite metodo findById(fimId)
			List<Film> listaFilm = filmService.orderByName();
			//info relative al genere del medesimo film 
			//inoltro informazioni relative al film 
			request.setAttribute("listaFilm", listaFilm);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("lista_film_per_nome.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.html");
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}

