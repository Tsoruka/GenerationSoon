<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- RIFERIMENTI ALLA TAGLIB CORE <3 -->
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////////////////////// -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

	<!-- LOGO formato icona per finestra di navigazione web -->
    <!-- i dettagli fanno la differenza -->
    <link rel="icon" href="img/logo-grezzo.png" type="image/x-icon" />
    <!-- ////////////////////////////////////////////////// -->

	<!-- jQuery Api -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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

    <!-- JS -->
    <script src="js/slide.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="css/slide.css" />
  
</head>
<body>

<%@ include file="navbar.jsp" %>
  
  
    <!-- Wrapper -->
    <div class="wrapper">
    <!-- //////// -->
    
      <!-- Slide Carousel -->
      <div class="slide-carousel" id="one">
        <div class="arrow-left">&lsaquo;</div>
        <div class="arrow-right">&rsaquo;</div>

        <div class="slides" > 
       <!-- il carousel è collegato con le pagine tramite href, non avendo in database questi film, non corrispondono correttamente ma una volta popolato il database basta cambiare l'id del filmId  -->
          <div class="slide" id="slide1"> <a href="http://localhost:8080/GenerationSoon/dettaglio-film?filmId=1"><span class="title"></span></a></div> 
          <div class="slide" id="slide2"><a href="http://localhost:8080/GenerationSoon/dettaglio-film?filmId=2"><span class="title"></span></a></div>
          <div class="slide" id="slide3"><a href="http://localhost:8080/GenerationSoon/dettaglio-film?filmId=3"><span class="title"></span></a></div>
          <div class="slide" id="slide4"><a href="http://localhost:8080/GenerationSoon/dettaglio-film?filmId=4"><span class="title"></span></a></div>
          <div class="slide" id="slide5"><a href="http://localhost:8080/GenerationSoon/dettaglio-film?filmId=5"><span class="title"></span></a></div>
    	 		
      </div>
    </div>
    
	<!-- //////////// -->
	</div>    
	<!-- END Wrapper -->

<%@ include file="footer.html" %>

</body>
</html>