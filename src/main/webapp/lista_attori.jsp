<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Attori</title>
</head>
<body>
<h1> Lista Attori</h1>

<c:forEach items="${listaAttori}" var="attore">
				
	<form action="dettaglio-attore" method="get">
		<button style="cursor:pointer;" type="submit">
			<h1> ${attore.nome}</h1>
			<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQynIAJReBEhr6FGTQHQkIo0jmfWLY07G0J7qMOUQow9hBHf-Ad" width="400px" height="500px">
			<h3> ${attore.cognome} </h3>
			<input type="hidden" name="attoreId" value="${attore.id}">
		</button>
		
	</form>
	</c:forEach>
</body>
</html>