<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- TAGLIB CORE <3  -->   
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////// -->

<!DOCTYPE html>
<html>
<head>
	<!-- Styles CSS -->
	<link rel="stylesheet" href="css/dettaglio.css">
	
	<!-- LOGO formato icona per finestra di navigazione web -->
    <!-- i dettagli fanno la differenza -->
    <link rel="icon" href="img/logo-grezzo.png" type="image/x-icon" />
    <!-- ////////////////////////////////////////////////// -->
    
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
	<main class="info-film margine">

      <div class="info-container container">

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
            <div class="contenitore__testo">
              <div>
                <span class="scritta">Nome : </span>
                <span class="info">${attore.nome} ${attore.cognome}</span>
              </div>
              <div >
                <span class="scritta">Data di nascita : </span>
                <span class="info"> ${attore.dataDiNascita}</span>
              </div>
              <div >
                <span class="scritta">Luogo di nascita : </span>
                <span class="info">${attore.luogoDiNascita}</span>
              </div>
              <div >
                <span class="scritta">Data di decesso : </span>
                <span class="info">${attore.dataDiDecesso}</span>
              </div>
              
              <div >
                <h2>Biografia</h2>
                <span class="descrizione-film">
                  ${attore.biografia}
                </span>
              </div>
              
            </div>


          </div>
        </div>

          

        <!--FILMOGRAFIA-->
        <h2 class="cast-heading">FILMOGRAFIA</h2>
        <div class="cast">
          
        <c:forEach items="${attore.film}" var="presente">
		<form action="dettaglio-film" method="get">
			<button class="cast-box" name="attoreId" value="${presente.film.id}">
				<img src="${presente.film.foto}" alt="" class="cast-img" />
				<span class="cast-title">${presente.film.titolo}</span>
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