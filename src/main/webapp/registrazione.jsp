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
    <link rel="stylesheet" type="text/css" href="css/form.css" />
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
            <div class="card text-dark" style="border-radius: 1rem; background-image: linear-gradient(45deg, #93a5cf 0%, #e4efe9 100%);">
              <div class="card-body p-5 text-center">
                <div class="mb-md-5 mt-md-4 pb-3">
                  <h2 class="fw-bold mb-2 text-uppercase">REGISTRAZIONE</h2>
                  <p class="text-dark-50 mb-5">
                    Inserisci i tuoi dati per registrarti!
                  </p>
					<form action="registrazione" method="post">
                  <div class="form-outline form-white mb-3">
                    <input
                      type="text"
                      name="nome"
                      class="form-control form-control-lg"
                      placeholder="Nome"
                      
                    />
                     <c:if test="${errorNome != null}">
                  	<p class="my-error">${errorNome}</p>
                    </c:if>
                  </div>

                  <div class="form-outline form-white mb-3">
                  <input
                  type="text"
                  name="cognome"
                  class="form-control form-control-lg"
                  placeholder="Cognome"
                  
                  />
                 
                  
                  <c:if test="${errorCognome != null}">
                  	<p class="my-error">${errorCognome}</p>
                  </c:if>
                  </div>
                  
				  <div class="form-outline form-white mb-3">
                  <input
                  type="text"
                  name="email"
                  class="form-control form-control-lg"
                  placeholder="Email"
                
                  />
                  <c:if test="${errorEmail != null}">
                  	<p class="my-error">${errorEmail}</p>
                  </c:if>
                  <c:if test="${param.errorUtenteEmail != null}">
                  	<p class="my-error">Email già registrata</p>
                  </c:if>
                  
                  </div>
                  
                  <div class="form-outline form-white mb-3">
                  <input
                  type="text"
                  name="username"
                  class="form-control form-control-lg"
                  placeholder="Username"
                  
                  />
                  <c:if test="${errorUsername != null}">
                  	<p class="my-error">${errorUsername}</p>
                  </c:if>
                  
                  <c:if test="${param.errorUtenteUser != null }">
                  	<p class="my-error">Username già in uso</p>
                  </c:if>
                 
                  </div>

                  <div class="form-outline form-white mb-3">
                  <input
                      type="password"
                      name="password"
                      class="form-control form-control-lg"
                      placeholder="Password"
                      
                    />
                    <c:if test="${errorPassword != null}">
                  	<p class="my-error">${errorPassword}</p>
                  </c:if>
                    
                  </div>

					<c:if test="${param.errorUtente != null}">
                  	<p class="my-error">Email e Username già in uso</p>
                  </c:if>

                  <button class="btn btn-grad btn-lg"
                    type="submit">
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