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
	
	<!-- LOGO formato icona per finestra di navigazione web -->
    <!-- i dettagli fanno la differenza -->
    <link rel="icon" href="img/logo-grezzo.png" type="image/x-icon" />
    <!-- ////////////////////////////////////////////////// -->
	
	<meta charset="ISO-8859-1">
	<title>Lista Attori</title>
</head>
<body>

	<!--NAVBAR GREZZO SOON -->
	<%@ include file="navbar.jsp" %>
	
	<!-- Wrapper -->
    <div class="wrapper">
    <!-- //////// -->
	
	<!--CERCA FILM PER TITOLO -->
	<%@ include file="cerca_attore.jsp" %>

	<!--LISTA ATTORI-->
    <section class="attori container">
      <div class="attori-content">
      <c:forEach items="${listaAttori}" var="attore">
		<form action="dettaglio-attore" method="get">
        
        <button class="attore-card" name="attoreId" value="${attore.id}">
            <img
              src="${attore.foto}"
              alt=""
              class="attore-card-img"
            />
            <div class="box-text">
              <h3 class="attore-name">${attore.nome} ${attore.cognome}</h3>
            </div>
          </button>
          </form>
		</c:forEach>

   		</div>
 	  </section>
 
 
	<!-- //////////// -->
	</div>    
	<!-- END Wrapper -->
	
	<!--FOOTER @James Davey Design -->
	<%@ include file="footer.html" %>


</body>
</html>