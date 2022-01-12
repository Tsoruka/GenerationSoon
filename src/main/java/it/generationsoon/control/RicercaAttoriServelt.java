package it.generationsoon.control;

import java.io.IOException;
import java.util.List;

import it.generationsoon.model.Attore;
import it.generationsoon.service.AttoreService;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.impl.AttoreServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RicercaAttori
 */
@WebServlet("/ricerca-attori")
public class RicercaAttoriServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AttoreService attoreService = new AttoreServiceImpl();

    /**
     * Default constructor. 
     */
    public RicercaAttoriServelt() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//creazione di un oggetto tipo film a partire dal filmService
			//tramite metodo findById(fimId)
			List<Attore> listaAttori = attoreService.findAll();
			//info relative al genere del medesimo film 
			
			//inoltro informazioni relative al film 
			request.setAttribute("listaAttori", listaAttori);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("lista_attori.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.jsp");
		}
	
	}



}
