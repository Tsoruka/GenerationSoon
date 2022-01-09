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
 * Servlet implementation class FiltroGenereAnnoServlet
 */
@WebServlet("/filtro-genere-anno")
public class FiltroGenereAnnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FiltroGenereAnnoServlet() {
        // TODO Auto-generated constructor stub
    }
    private FilmService filmService = new FilmServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String genere = request.getParameter("genere");
		String annoStr = request.getParameter("anno");
		int anno = 0;
		if (annoStr.isBlank() == false){
			// try/catch inserito per gestire i casi in cui annoStr non è type int
			// preferibilmente da gestire lato frontend
			try {
		anno = Integer.parseInt(annoStr);
			}
			catch (NumberFormatException e) {
				System.err.println(e.getMessage());
				response.sendRedirect("500.html");
				return;
			}
		}
		
		

		try {
			//creazione di un oggetto tipo film a partire dal filmService
			//tramite metodo findById(fimId)
	List<Film> listaFilm = filmService.filterByGenereAndAnno(genere, anno);
			//info relative al genere del medesimo film 
			
			//inoltro informazioni relative al film 
			request.setAttribute("listaFilm", listaFilm);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("lista_film.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.jsp");
		}
	}

}
