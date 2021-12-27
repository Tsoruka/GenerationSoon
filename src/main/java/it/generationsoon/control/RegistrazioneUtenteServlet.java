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
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class RegistrazioneUtenteServlet
 */
@WebServlet("/registrazione")
public class RegistrazioneUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtenteService utenteService = new UtenteServiceImpl();

    
    public RegistrazioneUtenteServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente = new Utente();
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setUsername(request.getParameter("username"));
		utente.setPassword(request.getParameter("password"));
		
		if(validate(request)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		try {
			utenteService.save(utente);
			HttpSession session = request.getSession();
			session.setAttribute("utente", utente);
			session.setAttribute("username", utente.getUsername());
			session.setAttribute("idUtente", utente.getId());
			//TODO forse aggiungere voto
			response.sendRedirect("login.jsp"); // forse serve servlet
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.html");
		}
	}
	
	private boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean hasErrors = false;

		if (nome == null || nome.trim().isEmpty()) {
			request.setAttribute("errorNome", "campo nome obbligatorio");
			hasErrors = true;
		}
		
		if (cognome == null || cognome.trim().isEmpty()) {
			request.setAttribute("errorCognome", "campo cognome obbligatorio");
			hasErrors = true;
		}
		
		if (email == null || email.trim().isEmpty()) {
			request.setAttribute("errorEmail", "campo email obbligatorio");
			hasErrors = true;
		}

		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("errorUsername", "campo username obbligatorio");
			hasErrors = true;
		}

		if (password == null || password.trim().isEmpty()) {
			request.setAttribute("errorPassword", "campo password obbligatorio");
			hasErrors = true;
		}

		return hasErrors;
	}

}
