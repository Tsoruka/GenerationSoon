<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- TAGLIB CORE <3  -->   
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////// -->

<!-- TAGLIB FORMAT per avere la prima cifra significativa dopo la virgola (double mediaVotiUtente)  -->  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- /////////////////////////////////////////////////////////////////////////////////////////////  -->

<!DOCTYPE html>
<html>
<head>
	<!-- Styles CSS -->
	<link rel="stylesheet" href="css/dettaglio.css">
	<link rel="stylesheet" href="css/modal-voto.css">
	
	<!-- LOGO formato icona per finestra di navigazione web -->
    <!-- i dettagli fanno la differenza -->
    <link rel="icon" href="img/logo-grezzo.png" type="image/x-icon" />
    <!-- ////////////////////////////////////////////////// -->
    
     <script
      src="https://kit.fontawesome.com/a3b71d67d8.js"
      crossorigin="anonymous"
    ></script>
    
	<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Film info</title>
</head>
<body>

	
	
	<!--NAVBAR GREZZO SOON -->
	<%@ include file="navbar.jsp" %>

	<!-- Wrapper -->
    <div class="wrapper">
    <!-- //////// -->

	<!--DETTAGLIO FILM -->
	<main class="info-film margine">
      <div class="video-container play-container container">
        <!-- Play img-->
        <img src="${film.fotoGrande}" alt="" class="play-img" />
        <!-- Play text-->
        <div class="play-text">
          <h2>${film.titolo}</h2>
          <div class="anno__durata">
            <span class="anno">${film.anno}</span>
            <span>-</span>
            <span class="durata">${film.durata} minuti</span>
          </div>
          
          <!--Tags-->
            <div class="tags">
              <span class="genere">${film.genere.value}</span>
            </div>
            
          
          
          <!--Media Voti Utenti-->
            <div id="rating">
              <div>
                <span class="grezzo-rating">GrezzoSoon Rating </span>
                <i class="far fa-star" style="color: #ffcc00"></i>
                <span class="scritta-rating">
                  <fmt:formatNumber
                    type="number"
                    maxFractionDigits="1"
                    minFractionDigits="1"
                    value="${film.mediaVoti}"
                  />
                </span>
                <span>/10</span>
              </div>
            </div>
            
            
            <!--VOTO FILM MODAL-->
 
            <button type="button" class="bn4647 bn48"  data-modal-target="#modal">
            Vota ora!
          </button>
            
            <div class="modal" id="modal">
              <div class="modal-header">
                <div class="title">
                  <img class="logo-modal" src="img/grezzo.png" alt="" />
                </div>
                <button data-close-button class="close-button">&times;</button>
              </div>
              <div class="modal-body">
                <span>INSERISCI IL TUO VOTO</span>
              </div>
              <!---->
              <div class="modal-body">
                <!--<input class="label-modal" type="tel" id="voto" name="voto" />-->
                <form action="voto-utente" method="post">
                  <select
                    name="voto"
                    id="label-modal",
                    onfocus="this.size=5;"
                    onblur="this.size=1;"
                    onchange="this.size=1;">
                    
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                  </select>
                 
                  
                 <input type="hidden" name="utenteId" value="${sessionScope.idUtente}">
				<input type="hidden" name="filmId" value="${film.id}">
                
                <!---->
                <span class="voto-max">/10</span>
                <i class="fa fa-star star-modal" style="color: #ffcc00"></i>
              </div>

              <div class="modal-body">
               <c:if test="${sessionScope.idUtente!=null}">
                <button class="invia" type="submit">INVIA</button>
                </c:if>
                <c:if test="${sessionScope.idUtente==null}">
                <p class="my-error">E' necessario effettuare il 
                <a style="color: #5a86d3; text-decoration: underline; "href="login.jsp">login</a> per votare</p>
                </c:if>
              </div>
              </form>
            </div>

            <!--POP-UP-->
            <div id="overlay"></div>
            

          
          <!--Trailer Button-->
          <!--SCRIPT PER ANDARE GIù-->
            <button type="button" class="bn3637 bn38" onclick="scrollTrailer()">
            Guarda il trailer
          </button>

        </div>
      </div>
      
      
      
      <!--About-->
      <div class="info-container container">
        <h2>Descrizione</h2>
        <span class="descrizione-film">
          ${film.descrizione}
        </span>
        <div class="contenitore__testo">
          <div class="separatore">
            <span class="scritta">Distribuzione : </span>
            <span class="info">${film.distribuzione}</span>
          </div>
          <div class="separatore">
            <span class="scritta"
              >Regista :
              <!--Regista-->
            </span>
            <span class="info">${film.regista.nome} ${film.regista.cognome}</span>
          </div>
          <div class="separatore">
            <span class="scritta"
              >Cast :
              <!--Cast-->
            </span>
            <span class="info">
            <c:forEach items="${film.attori}" var="cast">
				${cast.attore.nome} ${cast.attore.cognome},
			</c:forEach> 
            
            </span>
          </div>
          <div class="separatore">
            <span class="scritta"
              >Paese :
              <!--Paese-->
            </span>
            <span class="info">${film.paese}</span>
          </div>
          <div class="">
            <span class="scritta"
              >Data di uscita :
              <!--Data-->
            </span>
            <span class="info">${film.dataDiUscita}</span>
          </div>
          <!--</div>-->
        </div>
        
        <!--CAST-->
        <h2 class="cast-heading">CAST</h2>
        <div class="cast">
        
        <c:forEach items="${film.attori}" var="cast">
		<form action="dettaglio-attore" method="get">
			<button class="cast-box" name="attoreId" value="${cast.attore.id}">
				<img src="${cast.attore.foto}" alt="" class="cast-img" />
				<span class="cast-title">${cast.attore.nome} ${cast.attore.cognome}</span>
				<span class="anno">as <i>${cast.nomeRuolo}</i></span>
			</button>
		</form>
		</c:forEach>
		
        </div>
      </div>
      
       <!--TRAILER FILM-->
      <div>
        <div class="video-container">
          <iframe
            width="100%"
            height="900"
            src="${film.trailer}"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </div>
      </div>
    </main>
	
	<!-- //////////// -->
	</div>    
	<!-- END Wrapper -->

	<!--FOOTER @James Davey Design -->
	<%@ include file="footer.html" %>
	
	<!--JAVASCRIPT per bottone guarda trailer-->
    <script>
      function scrollTrailer() {
        window.scrollTo(0, 1500);
      }
    </script>
    
    <!-- JS -->
    <script src="js/modal-voto.js"></script>
	
	 
</body>
</html>