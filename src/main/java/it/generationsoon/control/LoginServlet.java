package it.generationsoon.control;

import java.io.IOException;

import it.generationsoon.model.Utente;
import it.generationsoon.service.ServiceException;
import it.generationsoon.service.UtenteService;
import it.generationsoon.service.impl.UtenteServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtenteService utenteService = new UtenteServiceImpl();

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			Utente utente = utenteService.findByUsername(username);
			if(utente != null && utente.getPassword().equals(password)) {
				request.getSession().setAttribute("idUtente", utente.getId());
				request.getSession().setAttribute("username", utente.getUsername());
				// request.getSession().setAttribute("utente", utente);
				response.sendRedirect("index.html");
			} else {
				response.sendRedirect("500.html");
				// TODO password errata/chiedere di reinserire dati
			}
			
		} catch (ServiceException e) {
			// response.sendRedirect("500.html");
			// response.sendRedirect("login.jsp?error2");
			System.err.println(e.getMessage());
		}

	}
	

}
