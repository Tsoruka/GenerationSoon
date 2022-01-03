<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- TAGLIB CORE <3  -->   
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////// -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Film info</title>
</head>
<body>

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
	
	<!-- solo a titolo esplicativo -->
	<p>idUtente in session => ${sessionScope.idUtente}</p>
	<p>film id => ${film.id} </p>
	<!-- ///////////////////////// -->
			
		<input type="hidden" name="utenteId" value="${sessionScope.idUtente}">
		<input type="hidden" name="filmId" value="${film.id}">
		<input type="text" name="voto" placeholder="8"> /10
		<input type="submit" name="Dai un voto">
	</form>
	
	<br>
	<h3>Cast: </h3>
	<!-- 
	<p>${film.attori}</p>  -->
	<c:forEach items="${film.attori}" var="cast">
		<form action="dettaglio-attore" method="get">
		<button style="cursor:pointer;" type="submit">
		<p>${cast.attore.nome} ${cast.attore.cognome} interpreta <i>${cast.nomeRuolo}</i></p>
			<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQynIAJReBEhr6FGTQHQkIo0jmfWLY07G0J7qMOUQow9hBHf-Ad" width="400px" height="500px">
			<input type="hidden" name="attoreId" value="${cast.attore.id}">
		</button>
		</form>
		
	</c:forEach>
	
	 
</body>
</html>