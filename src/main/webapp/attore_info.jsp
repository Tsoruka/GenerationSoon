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
<title>Attore info</title>
</head>
<body>

	<h1>Nome: ${attore.nome}</h1>
	<h3>Cognome: ${attore.cognome} </h3>
	<h3>Data di nascita: ${attore.dataDiNascita}</h3>
	<br>
	<br>
	<h3>Luogo di nascita: ${attore.luogoDiNascita}</h3>
	<br>
	<br>
	<h3>Data di decesso: ${attore.dataDiDecesso}</h3>
	<br>
	<h3>Biografia: ${attore.biografia}</h3>
	<br>
	<br>
</body>
</html>