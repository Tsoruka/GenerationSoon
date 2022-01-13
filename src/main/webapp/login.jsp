<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Riferimenti alla taglib core <3 -->
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////////////////////// -->

<!DOCTYPE html>
<html>
<head>
    <!--BOOTSTRAP CSS-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
      />
	<!-- Styles CSS -->
	<link rel="stylesheet" href="css/form.css">
	
	<!-- LOGO formato icona per finestra di navigazione web -->
    <!-- i dettagli fanno la differenza -->
    <link rel="icon" href="img/logo-grezzo.png" type="image/x-icon" />
    <!-- ////////////////////////////////////////////////// -->
	
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Login</title>
</head>
<body>

	<!-- FRECCIA PER TORNARE A MENU PRINCIPALE -->
	<div class="encircle">
	<c:set value="${pageContext.request.contextPath}"
        var="contextUrl" />
	
     <a href="${contextUrl}"> <div class="arrow"></div></a>
    </div>
    
    <!-- LOGIN FORM --> 
    <section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div
          class="row d-flex justify-content-center align-items-center h-50 contenitore">
          <div class="col-10 col-sm-10 col-md-8 col-lg-6 col-xl-5">
            <div style="border-radius: 1rem; background-color: none">
              <div class="card-body p-5">
                <div class="mb-md-5 mt-md-4">
                  <img
                    src="img/grezzo.png"
                    class="rounded mx-auto d-block properties"
                    alt="..."
                  />
                  <h2 class="fw-bold mb-2">Accedi</h2>
                   <c:if test="${param.errorVoto != null}">
                  	<p class="my-error">Per votare è necessario effetttuare il login</p>
                    </c:if>
                  <p class="text-dark-50 mb-4">
                    Inserisci i tuoi dati per accedere
                  </p>
                  
                  <!-- FORM COLLEGAMENTO SERVLET -->
				  <form action="login" method="post">
				  <!-- ///////////////////////// -->
				   
                  <div class="form-outline form-white mb-4">
                    <input
                      type="text"
                      name="username"
                      class="form-control form-control-lg"
                      placeholder="Username"
                    />
                     <c:if test="${param.errorUser != null}">
                  	<p class="my-error">Utente non esistente</p>
                    </c:if>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <input
                      type="password"
                      name="password"
                      class="form-control form-control-lg"
                      placeholder="Password"
                    />
                    <c:if test="${param.errorPassword != null}">
                  	<p class="my-error">Password errata</p>
                    </c:if>
                  </div>
                  

                  <button
                    class="btn btn-grad col-12 col-md-12 col-lg-12 px-5"
                    type="submit"
                    style="font-family: Avenir LT Pro, sans-serif">
                    Accedi
                  </button>
                  
                  <!-- chiusura FORM per collegamento a servlet -->
                  </form>
                  <!-- //////////////////////////////////////// -->
				
                </div>

                <div>
                  <p class="mb-0 margine">
                    Nuovo su Grezzo Soon?
                    <a
                      href="registrazione.jsp"
                      class="text-dark-50 fw-bold registrati"
                      style="color: #f9f9f9"
                      >Registrati</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>


</body>
</html>