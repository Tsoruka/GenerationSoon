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
    
      <!-- Slide Carousel -->
      <div class="slide-carousel" id="one">
        <div class="arrow-left">&lsaquo;</div>
        <div class="arrow-right">&rsaquo;</div>

        <div class="slides">
          <div class="slide" id="slide1"><span class="title"></span></div>
          <div class="slide" id="slide2"><span class="title"></span></div>
          <div class="slide" id="slide3"><span class="title"></span></div>
          <div class="slide" id="slide4"><span class="title"></span></div>
          <div class="slide" id="slide5"><span class="title"></span></div>
    	
      </div>
    </div>
    


<%@ include file="footer.jsp" %>

</body>
</html>