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
 * Servlet implementation class TrovaFilmPerTitolo
 */
@WebServlet("/trova-film-per-titolo")
public class TrovaFilmPerTitoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TrovaFilmPerTitoloServlet() {
        // TODO Auto-generated constructor stub
    }
    
    private FilmService filmService = new FilmServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titolo = request.getParameter("titolo");
		try {
			//creazione di un oggetto tipo film a partire dal filmService
			//tramite metodo findById(fimId)
	List<Film> listaFilm = filmService.findByTitolo(titolo);
			//info relative al genere del medesimo film 
			
			//inoltro informazioni relative al film 
			request.setAttribute("listaFilm", listaFilm);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("lista_film.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.html");
		}
	}


}
