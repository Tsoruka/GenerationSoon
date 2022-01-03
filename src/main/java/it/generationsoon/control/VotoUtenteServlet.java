package it.generationsoon.control;

import java.io.IOException;

import it.generationsoon.dao.impl.VotoUtenteDAOImpl;
import it.generationsoon.model.Utente;
import it.generationsoon.model.VotoUtente;
import it.generationsoon.service.UtenteService;
import it.generationsoon.service.VotoUtenteService;
import it.generationsoon.service.impl.UtenteServiceImpl;
import it.generationsoon.service.impl.VotoUtenteServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VotoUtenteServlet
 */
@WebServlet("/voto-utente")
public class VotoUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotoUtenteService votoUtenteService = new VotoUtenteServiceImpl();
	private UtenteService utente = new UtenteServiceImpl();
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
			int utenteId = Integer.parseInt(request.getSession().getAttribute("idUtente").toString());
			int filmId = Integer.parseInt(request.getParameter("filmId"));
			int voto = Integer.parseInt(request.getParameter("voto"));
			//utente = VotoUtenteService.findById(utenteId);
			//VotoUtente votoUtente = new VotoUtente(); 
			//votoUtente.setUtente().setId();
			//votoUtente.save(null)
			
			
	}

}
