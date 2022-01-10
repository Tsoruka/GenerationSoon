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
	<link rel="stylesheet" href="css/form.css">
	
	<meta charset="ISO-8859-1">
	<title>Search box</title>
</head>
<body>
	 
	 <!-- SEACH BOX - CERCA FILM PER TITOLO -->
	 <section class="container">
       <!-- FORM COLLEGAMENTO SERVLET -->
       <form action="trova-attore-per-nome-cognome" method="get">
       <!-- ///////////////////////// -->
		
		<div class="row g-3" style="padding-left:30px; padding-right:30px;">
		
		<div class="col">
         <div class="form-outline form-white mb-4">
           <input
             type="text"
             name="titolo"
             class="form-control form-control-lg"
             placeholder="Inserisci attore"
           />
		   </div> 
		  
		</div>
       
       <div class="col">
			<button class="btn btn-grad col-4 col-md-3 col-lg-4 px-5" type="submit" style="font-family: Avenir LT Pro, sans-serif">
       			 Cerca
			</button>	
	   </div>
	   </div>
       
       <!-- chiusura FORM per collegamento a servlet -->
       </form>
       <!-- //////////////////////////////////////// -->
       
    </section>
</body>
</html>