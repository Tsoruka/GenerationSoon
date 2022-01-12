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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utente utente = new Utente();
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setUsername(request.getParameter("username"));
		utente.setPassword(request.getParameter("password"));

		if (validate(request)) {
			request.getRequestDispatcher("registrazione.jsp").forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		try {
			String controlloUsername = utenteService.usernameInUso(utente.getUsername());
			String controlloEmail = utenteService.emailInUso(utente.getEmail());
			if (controlloEmail == "error" && controlloUsername == "error") {
				utenteService.save(utente);

				session.setAttribute("utente", utente);
				session.setAttribute("username", utente.getUsername());
				session.setAttribute("idUtente", utente.getId());
				response.sendRedirect("login.jsp");
			} 	
			else if (controlloEmail.equals(utente.getEmail()) && controlloUsername.equals("error")) {
				response.sendRedirect("registrazione.jsp?errorUtenteEmail");
			} else if (controlloUsername.equals(utente.getUsername()) && controlloEmail.equals("error")) {
				response.sendRedirect("registrazione.jsp?errorUtenteUser");
			} 
			else if(controlloEmail.equals(utente.getEmail()) && controlloUsername.equals(utente.getUsername())) {		
				response.sendRedirect("registrazione.jsp?errorUtente");
			}
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
			response.sendRedirect("500.jsp");
		}
	}

	private boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean hasErrors = false;

//		if(utenteService.findByUsername(username) == null) {
//			request.setAttribute("errorUtente", "Username già in uso");
//		}

		if (nome == null || nome.trim().isEmpty()) {
			request.setAttribute("errorNome", "Campo nome obbligatorio");
			hasErrors = true;
		}

		if (cognome == null || cognome.trim().isEmpty()) {
			request.setAttribute("errorCognome", "Campo cognome obbligatorio");
			hasErrors = true;
		}

		if (email == null || email.trim().isEmpty()) {
			request.setAttribute("errorEmail", "Campo email obbligatorio");
			hasErrors = true;
		}

		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("errorUsername", "Campo username obbligatorio");
			hasErrors = true;
		}

		if (password == null || password.trim().isEmpty()) {
			request.setAttribute("errorPassword", "Campo password obbligatorio");
			hasErrors = true;
		}

		return hasErrors;
	}

}
