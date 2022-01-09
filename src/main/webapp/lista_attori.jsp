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
	<link rel="stylesheet" href="css/lista-attori.css">
	
	<meta charset="ISO-8859-1">
	<title>Lista Attori</title>
</head>
<body>

	<!--NAVBAR GREZZO SOON -->
	<%@ include file="navbar.jsp" %>

	<!--LISTA ATTORI-->
    <section class="attori container">
      <div class="attori-content">
      <c:forEach items="${listaAttori}" var="attore">
		<form action="dettaglio-attore" method="get">
        
        <button class="attore-card">
            <img
              src="https://lofficiel.imgix.net/production/monaco/images/1606754919732485-robert-pattinson-dior-campaing-5.jpeg?w=1900&fit=crop&crop=faces&auto=%5B%22format%22%2C%20%22compress%22%5D&cs=srgb"
              alt=""
              class="attore-card-img"
            />
            <div class="box-text">
              <h3 class="attore-name">${attore.nome} ${attore.cognome}</h3>
              <input type="hidden" name="attoreId" value="${attore.id}">
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