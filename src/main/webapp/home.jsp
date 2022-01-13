<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- RIFERIMENTI ALLA TAGLIB CORE <3 -->
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /////////////////////////////// -->

<!DOCTYPE html>
<html>
<head>
	<!-- nasconde scroll down browser -->
	<style type="text/css">
        body::-webkit-scrollbar {
            display: none;
        }
    </style>

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
    
    
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
 	
 	<!-- CDN Slick Slider -->
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.9/slick.min.css'>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.9/slick-theme.min.css'>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <!-- Styles CSS -->
    
    <link rel="stylesheet" href="css/homepage/overlay.css">
    <link rel="stylesheet" href="css/homepage/slider.css">
    <link rel="stylesheet" href="css/homepage/film.css">
    
    
    

    <!-- JS CAROUSEL-->
    <script src="js/slide-carousel.js"></script>
    
    
    <!-- CSS CAROUSEL-->
    <link rel="stylesheet" href="css/slide.css" />
  
  	<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Home</title>
</head>
<body>

<%@ include file="navbar.jsp" %>
  
  
    <!-- Wrapper -->
    <div class="wrapper">
    <!-- //////// -->
    
      <!-- /////////////////////////////////////////////// Slide Carousel /////////////////////////////////////////////// -->
      <div class="slide-carousel" id="one">
        <div class="arrow-left">&lsaquo;</div>
        <div class="arrow-right">&rsaquo;</div>

        <div class="slides" > 
       <!-- il carousel è collegato con le pagine tramite href, non avendo in database questi film, non corrispondono correttamente ma una volta popolato il database basta cambiare l'id del filmId  -->
          <div class="slide" id="slide1"> <a href="dettaglio-film?filmId=1"><span class="title"></span></a></div> 
          <div class="slide" id="slide2"><a href="dettaglio-film?filmId=2"><span class="title"></span></a></div>
          <div class="slide" id="slide3"><a href="dettaglio-film?filmId=3"><span class="title"></span></a></div>
          <div class="slide" id="slide4"><a href="dettaglio-film?filmId=4"><span class="title"></span></a></div>
          <div class="slide" id="slide5"><a href="dettaglio-film?filmId=5"><span class="title"></span></a></div>
    	 		
      </div>
    </div>
    <!-- /////////////////////////////////////////////// END CAROUSEL //////////////////////////////////////////////// -->
    
    
    
    <!-- /////////////////////////////////////////////  Section Films  //////////////////////////////////////////////  -->
    <div class="container-general">
        <header></header>
        <!-- Films -->
        <div class="main movies-rows">
            <h3 class="list-title">AL CINEMA</h3>
            <div class="slider responsive">
              <c:forEach items="${listaFilmUscita}" var="film">
            	<form action="dettaglio-film" method="get">
            		<button class="card" name="filmId" value="${film.id}">
            		<h3>
            		<img src="${film.foto}">
            		</h3>
            		</button>
            	</form>
            </c:forEach>
            </div>
            
            <h3 class="list-title">I PI&Uacute APPREZZATI DAL PUBBLICO </h3>
            <div class="slider responsive">
            <c:forEach items="${listaFilmVoto}" var="film">
            	<form action="dettaglio-film" method="get">
            		<button class="card" name="filmId" value="${film.id}">
            		<h3>
            		<img src="${film.foto}">
            		</h3>
            		</button>
            	</form>
            </c:forEach>
            </div>
            
            <h3 class="list-title">MARVEL STUDIOS</h3>
            <div class="slider responsive">
              <c:forEach items="${listaFilmMarvel}" var="film">
            	<form action="dettaglio-film" method="get">
            		<button class="card" name="filmId" value="${film.id}">
            		<h3>
            		<img src="${film.foto}">
            		</h3>
            		</button>
            	</form>
            </c:forEach>
            </div>
          </div>
        </div>
    </div>
    <!-- /////////////////////////////////////////////  END Section Films  //////////////////////////////////////////////  -->
    
    
	<!-- //////////// -->
	</div>    
	<!-- END Wrapper -->

<%@ include file="footer.html" %>

</body>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js'></script>
<script src="js/slider-home.js"></script>
</html>