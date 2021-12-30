<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/form.css" />
<title>Registrazione</title>
<link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
      integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
      crossorigin="anonymous"
    />
</head>
<body>
<section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem">
              <div class="card-body p-5 text-center">
                <div class="mb-md-5 mt-md-4 pb-3">
                  <h2 class="fw-bold mb-2 text-uppercase">REGISTRAZIONE</h2>
                  <p class="text-white-50 mb-5">
                    Inserisci i tuoi dati per registrarti!
                  </p>
					<form action="registrazione" method="post">
                  <div class="form-outline form-white mb-3">
                    <input
                      type="text"
                      id="nome_new_utente"
                      name="nome"
                      class="form-control form-control-lg"
                      
                    />
                    <!--  riuscita a bloccare pagina se non messi tutti i dati 
                    ma niente messaggio di errore -->
                     <c:if test="${errorNome != null}">
                  	<p class="error">${errorNome}</p>
                  </c:if>
                    <label class="form-label" for="nome_new_utente">Nome</label>
                  </div>

                  <div class="form-outline form-white mb-3">
                  <input
                  type="text"
                  id="cognome_new_utente"
                  name="cognome"
                  class="form-control form-control-lg"
                  required
                  />
                  
                  <label class="form-label" for="cognome_new_utente">Cognome</label>
                  </div>
                  
				  <div class="form-outline form-white mb-3">
                  <input
                  type="text"
                  id="email_new_utente"
                  name="email"
                  class="form-control form-control-lg"
                  required
                  />
                  <label class="form-label" for="email_new_utente">Email</label>
                  </div>
                  
                  <div class="form-outline form-white mb-3">
                  <input
                  type="text"
                  id="username_new_utente"
                  name="username"
                  class="form-control form-control-lg"
                  required
                  />
                  <label class="form-label" for="username_new_utente">Username</label>
                  </div>

                  <div class="form-outline form-white mb-3">
                  <input
                      type="password"
                      id="password_new_utente"
                      name="password"
                      class="form-control form-control-lg"
                      required
                    />
                    <label class="form-label" for="password_new_utente">Password</label>
                  </div>

                  <button
                    class="btn btn-outline-light btn-lg px-5"
                    type="submit"
                  >
                    Registrati
                  </button>
				</form>
                  
                </div>
                
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>