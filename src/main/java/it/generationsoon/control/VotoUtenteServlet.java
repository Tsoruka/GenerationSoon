package it.generationsoon.control;

import java.io.IOException;

import it.generationsoon.service.ServiceException;
import it.generationsoon.service.VotoUtenteFilmService;
import it.generationsoon.service.impl.VotoUtenteFilmServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class VotoUtenteServlet
 */
@WebServlet("/voto-utente")
public class VotoUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VotoUtenteFilmService votoUtenteFilmService = new VotoUtenteFilmServiceImpl();
    /**
     * Default constructor. 
     */
    public VotoUtenteServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//raccolgo parametri della pagina film_info-jsp corrente
		//che mi fornisce filmId
		int filmId = Integer.parseInt(request.getParameter("filmId"));
		//voto che utente (in session) assegna al film corrente
		int voto = Integer.parseInt(request.getParameter("voto"));
		
		//dichiaro la session separatemente per rendere il codic epiù pulito e leggibile 
		//in una parola ELEGANTE, ogni riferimento è puramente casuale (per il Signor Monroe) 
		HttpSession session = request.getSession();
		try {
			//richiamo idUtente salvato in session con login utente
			if (session.getAttribute("idUtente")==null) {
				response.sendRedirect("film_info.jsp?errorLogin");
				response.sendRedirect("login.jsp?errorVoto");
			}
			else {
			int utenteId = (Integer) session.getAttribute("idUtente");
			
			//variabile di controllo per scelta del tipo di voto save/update 
			int controllo = votoUtenteFilmService.votato(filmId, utenteId);
			
			//se controllo è a 0 allora save new voto 
			if(controllo == 0) {
				votoUtenteFilmService.save(filmId, utenteId, voto);
				response.sendRedirect("trova-tutti-film");
			} else if(controllo > 0) {
				votoUtenteFilmService.update(filmId, utenteId, voto);
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("500.jsp");
				
			}
			
			}	
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.jsp");
		}			
	}

}
