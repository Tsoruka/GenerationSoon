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
	
	<meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Search box</title>
</head>
<body>

	 
	 <!-- SEACH BOX - CERCA FILM PER TITOLO -->
	 <section class="container">
       <!-- FORM COLLEGAMENTO SERVLET -->
       <form action="filtro-genere-anno" method="get">
       <!-- ///////////////////////// -->
	
             <!-------------------------->
          <div class="outer-div">
          <div class="spazio-box inner-div">
          
          <div class="row g-3" style="padding-left:30px; padding-right:30px;">
		
			<div class="col">
          
          
            <h2 class="genere" style="color:white">Genere</h2>
            <label for="generi"></label>
            <input
              placeholder="Nessun genere selezionato.."
              list="generi"
              id="selection"
              name="genere"
              spellcheck="false"
            />

            <datalist id="generi">
              <option value="ANIMAZIONE"></option>
              <option value="AZIONE"></option>
              <option value="AVVENTURA"></option>
              <option value="BIOGRAFIA"></option>
              <option value="COMMEDIA"></option>
              <option value="DOCUMENTARIO"></option>
              <option value="DRAMMATICO"></option>
              <option value="FANTASCIENZA"></option>
              <option value="FANTASTICO"></option>
              <option value="GIALLO"></option>
              <option value="GUERRA"></option>
              <option value="HORROR"></option>
              <option value="MUSICALE"></option>
              <option value="SENTIMENTALE"></option>
              <option value="STORICO"></option> 
              <option value="THRILLER"></option>
              <option value="WESTERN"></option>
            </datalist>
			</div>
			
			<div class="col">
			<h2 class="anno" style="color:white">Anno</h2>
            <label for="ice-cream-choice"></label>
            <input
              placeholder="Nessun anno selezionato.."
              list="anni"
              id="selection"
              name="anno"
              spellcheck="false"
            />
            
          </div>
          
          <div class="col">
          <h2 class="genere" style="opacity: 0">Submit</h2>
          	<button class="invia">INVIA</button>
          </div>
		</div>
          <!-------------------------->
		</div>

	   
	   </div>
       
       <!-- chiusura FORM per collegamento a servlet -->
       </form>
       <!-- //////////////////////////////////////// -->
       
    </section>
    
    
</body>
</html>