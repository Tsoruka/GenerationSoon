<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- TAGLIB CORE <3  -->   
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- /////////////// -->

<!DOCTYPE html>
<html>
<head>
	<!-- nasconde scroll down browser -->
	<style type="text/css">
        body::-webkit-scrollbar {
            display: none;
        }
    </style>
    
	<!-- Styles CSS -->
	<link rel="stylesheet" href="css/dettaglio.css">
	
	<!-- LOGO formato icona per finestra di navigazione web -->
    <!-- i dettagli fanno la differenza -->
    <link rel="icon" href="img/logo-grezzo.png" type="image/x-icon" />
    <!-- ////////////////////////////////////////////////// -->
    
    <!-- Fonts & Icons -->
    <link
      href="https://fonts.googleapis.com/css2?family=Advent+Pro:wght@100;200;300;400;500;600;700&family=Cabin:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet"
    />
    <script
      src="https://kit.fontawesome.com/828184f452.js"
      crossorigin="anonymous"
    ></script>
    
	<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Attore info</title>
</head>
<body>

	<!--NAVBAR GREZZO SOON -->
	<%@ include file="navbar.jsp" %>

	<!-- Wrapper -->
    <div class="wrapper">
    <!-- //////// -->
	
	<!--DETTAGLIO ATTORE -->
	<main class="info-attore margine">

      <div class=" container-attore">

        <div class="row">
          <!-- FOTO ATTORE -->
          <div class="column" style="padding-top: 2rem;">
            <img
            src="${attore.foto}"
            alt=""
            class="attore-img"
            /> 
          </div>
          <div class="column" style="padding-left: 1.5rem; padding-right: 3rem;">
            
            <!-- ABOUT ATTORE -->
            <div class="contenitore__testo box-attore">
              <div>
             
                <span class="info nome-attore">${attore.nome} ${attore.cognome}</span>
              </div>
              <div >
                <span class="scritta">Data di nascita : </span>
                <span class="info"> ${attore.dataDiNascita}</span>
              </div>
              <div >
                <span class="scritta">Luogo di nascita : </span>
                <span class="info">${attore.luogoDiNascita}</span>
              </div>
              <c:if test="${attore.dataDiDecesso != null }">
              <div >
                <span class="scritta">Data di decesso : </span>
                <span class="info"><fmt:formatDate pattern="dd-MM-yyyy" value="${attore.dataDiDecesso}" /></span>
              </div>
              </c:if>
              <div class="biografia">
                <h2>Biografia</h2>
                <span class="descrizione-film biografia">
                  ${attore.biografia}
                </span>
              </div>
              
            </div>


          </div>
        </div>
		</div>
          
		<div class="film-attore container-attore">
        <!--FILMOGRAFIA-->
        <h2 class="film-heading">FILMOGRAFIA</h2>
        <div class="filmografia">
          
        <c:forEach items="${attore.film}" var="presente">
		<form action="dettaglio-film" method="get">
			<button class="cast-box" name="filmId" value="${presente.film.id}">
				<img src="${presente.film.foto}" alt="" class="filmografia-img" />
				<span class="film-title">${presente.film.titolo}</span>
			</button>
		</form>
		</c:forEach>
          
        </div>
      </div>
      <div>
     
    </main>
	
	
	
	
	<!-- //////////// -->
	</div>    
	<!-- END Wrapper -->

	<!--FOOTER @James Davey Design -->
	<%@ include file="footer.html" %>
	
	
</body>
</html>