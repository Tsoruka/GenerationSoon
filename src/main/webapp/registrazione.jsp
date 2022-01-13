<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Riferimenti alla taglib core <3 -->
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////////////////////// -->

<!DOCTYPE html>
<html>
<head>
	<!-- nasconde scroll down browser -->
	<style type="text/css">
        body::-webkit-scrollbar {
            display: none;
        }
    </style>
    
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
	<title>Registrazione</title>
<link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
      integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
      crossorigin="anonymous"
    />
</head>
<body>

	<!-- FRECCIA PER TORNARE A MENU PRINCIPALE -->
	<div class="encircle">
	<c:set value="${pageContext.request.contextPath}"
        var="contextUrl" />
	
     <a href="${contextUrl}"> <div class="arrow"></div></a>
    </div>

	<!-- REGISTRAZIONE FORM --> 
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
        
          <div class="col-10 col-sm-10 col-md-8 col-lg-6 col-xl-5">
            <div style="border-radius: 1rem; background-color: none">
  
              <div class="card-body p-5">
                <div class="mb-md-5 mt-md-4">
                
                  <img
                    src="img/grezzo.png"
                    class="rounded mx-auto d-block properties"
                    alt="..."
                  />
                  
                  <h2 class="fw-bold mb-2">Registrazione</h2>
                  <p class="text-dark-50 mb-4">
                    Inserisci i tuoi dati per registrarti
                  </p>
                  
                  <!-- FORM COLLEGAMENTO SERVLET -->
				  <form action="registrazione" method="post">
				  <!-- ///////////////////////// -->
				  
					
                  <div class=" form-white row mb-4">
                    <div class="col">
                      <input type="text" 
                      name="nome"
                      class="form-control" 
                      placeholder="Nome">
                    </div>
                  	 <!-- My error - taglib core <3 -->
                     <c:if test="${errorNome != null}">
                  	<p class="my-error">${errorNome}</p>
                    </c:if>
                    <!-- ////////////////////////// -->
                  

                  <div class="col">
                      <input type="text" 
                      name="cognome"
                      class="form-control" 
                      placeholder="Cognome">
                    </div>
                 <!-- My error - taglib core <3 -->
                  <c:if test="${errorCognome != null}">
                  	<p class="my-error">${errorCognome}</p>
                  </c:if>
                  <!-- ////////////////////////// -->
                 </div>
                  
				  <div class="form-outline form-white mb-4">
                    <input
                      type="email"
                      name="email"
                      class="form-control form-control-lg"
                      placeholder="Email"
                    />
                  </div>
                  <!-- My error - taglib core <3 -->
                  <c:if test="${errorEmail != null}">
                  	<p class="my-error">${errorEmail}</p>
                  </c:if>
                  <c:if test="${param.errorUtenteEmail != null}">
                  	<p class="my-error">Email già registrata</p>
                  </c:if>
                  <!-- ////////////////////////// -->
                  
                  
                  <div class="form-outline form-white mb-4">
                    <input
                      type="text"
                      name="username"
                      class="form-control form-control-lg"
                      placeholder="Username"
                    />
                  </div>
                  <!-- My error - taglib core <3 -->
                  <c:if test="${errorUsername != null}">
                  	<p class="my-error">${errorUsername}</p>
                  </c:if>
                  
                  <c:if test="${param.errorUtenteUser != null }">
                  	<p class="my-error">Username già in uso</p>
                  </c:if>
                  <!-- ////////////////////////// -->
                  

                  <div class="form-outline form-white mb-4">
                    <input
                      type="password"
                      name="password"
                      class="form-control form-control-lg"
                      placeholder="Password"
                    />
                  </div>
                  <!-- My error - taglib core <3 -->
                  <c:if test="${errorPassword != null}">
                  	<p class="my-error">${errorPassword}</p>
                  </c:if>
                  <!-- ////////////////////////// -->
                  
				  
				   <!-- My error - taglib core <3 -->
				  <c:if test="${param.errorUtente != null}">
                  	<p class="my-error">Email e Username già in uso</p>
                  </c:if>
                  <!-- ////////////////////////// -->

                  <button
                    class="btn btn-grad col-12 col-md-12 col-lg-12 px-5"
                    type="submit"
                    style="font-family: Avenir LT Pro, sans-serif">
                    Registrati
                  </button>
				 <!-- chiusura FORM per collegamento a servlet -->
                  </form>
                 <!-- //////////////////////////////////////// --> 
                  </div>
                  
                 <p class="mb-0 margine">
                    Sei già registrato? 
                    <a
                      href="login.jsp"
                      class="text-dark-50 fw-bold registrati"
                      style="color: #f9f9f9"
                      >Accedi</a>
                </p>	
              
                  
                  
                  	
                
            </div>
          </div>
        </div>
      </div>
    
    
</body>
</html>