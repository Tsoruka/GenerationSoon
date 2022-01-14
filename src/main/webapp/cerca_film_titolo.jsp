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
       <div>
		
		
		<!-- FORM COLLEGAMENTO SERVLET -->
       <form class="row g-3" action="trova-film-per-titolo" method="get">
       <!-- ///////////////////////// -->
		<div class="col">
         <div class="form-outline form-white mb-4">
         <h2 class="genere" style="color:white">Titolo</h2>
           <input
             type="text"
             name="titolo"
             class="form-control form-control-lg"
             placeholder="Inserisci titolo film"
           />
		   </div> 
		  
		</div>
       
       <div class="col">
			<h2 class="genere" style="opacity: 0">Submit</h2>
          	<button class="invia">INVIA</button>
          </div>
           <!-- chiusura FORM per collegamento a servlet -->
       </form>
       <!-- //////////////////////////////////////// -->
          
	  
	  	<div class="col collapsible">
		     <h2 class="genere" style="opacity: 0">filtri</h2>
		   	<button class="invia" 
		   	id="filtroButton">Ricerca avanzata</button>
		</div>
	   
      
       
  
 
             <!-------------------------->
          <div class="content">
          <!-- FORM COLLEGAMENTO SERVLET -->
       		<form action="filtro-genere-anno" method="get">
       	  <!-- ///////////////////////// -->
       	  
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
 		
 		<!-- chiusura FORM per collegamento a servlet -->
       </form>
       <!-- //////////////////////////////////////// -->
	   
	   </div>


      
      </section>
    
    
    
    <script>
		var coll = document.getElementsByClassName("collapsible");
        var i;

        for (i = 0; i < coll.length; i++) {
          coll[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var content = this.nextElementSibling;
            if (content.style.maxHeight){
              content.style.maxHeight = null;
            } else {
              content.style.maxHeight = content.scrollHeight + "px";
            } 
          });
        }
	</script>
    
    
</body>
</html>