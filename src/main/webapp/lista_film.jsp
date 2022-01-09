<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
	<link rel="stylesheet" href="css/lista-film.css">
	
	
	<meta charset="ISO-8859-1">
	<title>Lista Film</title>
</head>
<body>

	<!--NAVBAR GREZZO SOON -->
	<%@ include file="navbar.jsp" %>
	
	<!--CERCA FILM PER TITOLO -->
	<%@ include file="search_box.jsp" %>

	<!--LISTA FILM-->
	<section class="movies container" id="film">
    	<div class="movies-content">

		<c:forEach items="${listaFilm}" var="film">
		
		<form action="dettaglio-film" method="get">
			<button class="movie-box">
              <img
                src="https://raw.githubusercontent.com/Tsoruka/MoviePosters/main/img/avventura/ai%20confini%20del%20mondo.jpg"
                alt=""
                class="movie-box-img"
              />
              <div class="box-text">
                <h3 class="movie-title">${film.titolo}</h3>
                <span class="movie-type">${film.genere.value}</span>
                <input type="hidden" name="filmId" value="${film.id}">
              </div>
            </button>
		</form>
		</c:forEach>
	
		</div>
  	</section>

	<!--FOOTER @James Davey Design -->
	<%@ include file="footer.html" %>
	
</body>
</html>