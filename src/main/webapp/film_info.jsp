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
	<link rel="stylesheet" href="css/dettaglio-film.css">
	
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
	
	<!--    

    <section class="container" id="">

	<h1>Titolo: ${film.titolo}</h1>

	<h3>Anno: ${film.anno} </h3>
	
	<h3>Durata: ${film.durata}</h3>
	
	<br>
	<br>
	<h3>Descrizione: </h3>
	<p>${film.descrizione}</p>
	<br>
	<br>
	<h3>Distribuzione: ${film.distribuzione}</h3>

	<h3>Paese: ${film.paese}</h3>
	
	<h3>Data di Uscita: ${film.dataDiUscita}</h3>
	
	<br>
	<br>
	
	<h3>Genere: ${film.genere.value}</h3>

	<h3>Regista: ${film.regista.nome} ${film.regista.cognome} </h3>
	
	<h3>Media voto: ${film.mediaVoti}</h3>
	<br>
	<form action="voto-utente" method="post">	
		<input type="hidden" name="utenteId" value="${sessionScope.idUtente}">
		<input type="hidden" name="filmId" value="${film.id}">
		<input type="text" name="voto" placeholder="8"> /10
		<input type="submit" name="Dai un voto">
	</form>
	
	<br>
	<h3>Cast: </h3>

	<c:forEach items="${film.attori}" var="cast">
		<form action="dettaglio-attore" method="get">
		<button style="cursor:pointer;" type="submit">
		<p>${cast.attore.nome} ${cast.attore.cognome} interpreta <i>${cast.nomeRuolo}</i></p>
			<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQynIAJReBEhr6FGTQHQkIo0jmfWLY07G0J7qMOUQow9hBHf-Ad" width="400px" height="500px">
			<input type="hidden" name="attoreId" value="${cast.attore.id}">
		</button>
		</form>
		
	</c:forEach>
	</section>
	-->

	<!-- Wrapper -->
    <div class="wrapper">
    <!-- //////// -->

	<!--DETTAGLIO FILM -->
	<main class="info-film margine">
      <div class="video-container play-container container">
        <!-- Play img-->
        <img src="https://raw.githubusercontent.com/Tsoruka/MoviePosters/prove/play-page/jumanji.jpg" alt="" class="play-img" />
        <!-- Play text-->
        <div class="play-text">
          <h2>${film.titolo}</h2>
          <div class="anno__durata">
            <span class="anno">${film.anno}</span>
            <span>-</span>
            <span class="durata">${film.durata} minuti</span>
          </div>
          
          <!--Media Voti Utenti-->
          <div id="rating">
          	<h4>Grezzo Soon Rating</h4>
            <i class="far fa-star" style="color: #ffcc00"></i>
			<span class="scritta-rating">
			<fmt:formatNumber type="number" maxFractionDigits="1" minFractionDigits="1" value="${film.mediaVoti}"/>
			</span>
			<span>/10</span> 
			
			 
			<button type="button" class="bn3637 bn38" onclick="scrollVoto()">
            Vota ora!
          	</button>
          </div>

          <!--Tags-->
          <div class="tags">
            <span class="genere">${film.genere.value}</span>
          </div>
          <!--Trailer Button-->
          <!--SCRIPT PER ANDARE GIù-->
          <button type="button" class="bn3637 bn38" onclick="scrollTrailer()">
            Guarda il trailer
          </button>
          
          <!--
          <form action="voto-utente" method="post">
	
	 solo a titolo esplicativo 
	<p>idUtente in session => ${sessionScope.idUtente}</p>
	<p>film id => ${film.id} </p>		
		<input type="hidden" name="utenteId" value="${sessionScope.idUtente}">
		<input type="hidden" name="filmId" value="${film.id}">
		<input type="text" name="voto" placeholder="8"> /10
		<input type="submit" name="Dai un voto">
	</form> -->
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
				<img src="https://raw.githubusercontent.com/Tsoruka/MoviePosters/prove/play-page/cast1.jpg" alt="" class="cast-img" />
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
            src="https://www.youtube.com/embed/L7B1OYlD9q8"
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
      
      function scrollVoto() {
          window.scrollTo(0, 1800);
        }
    </script>
	
	 
</body>
</html>