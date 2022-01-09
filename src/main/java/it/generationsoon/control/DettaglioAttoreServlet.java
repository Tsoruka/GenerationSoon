package it.generationsoon.control;

import java.io.IOException;

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
 * Servlet implementation class DettaglioAttoreServelt
 */
@WebServlet("/dettaglio-attore")
public class DettaglioAttoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AttoreService attoreService = new AttoreServiceImpl();

    /**
     * Default constructor. 
     */
    public DettaglioAttoreServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int attoreId = Integer.parseInt(request.getParameter("attoreId"));
		
		try {
			//creazione di un oggetto tipo film a partire dal filmService
			//tramite metodo findById(fimId)
			Attore attore = attoreService.findById(attoreId);
			//info relative al genere del medesimo film 
			
			//inoltro informazioni relative al film 
			request.setAttribute("attore", attore);
			
			//formula magica per inoltrare gli attributi alla nostra pagina web
			request.getRequestDispatcher("attore_info.jsp").forward(request, response);
			
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.jsp");
		}
	}


}
