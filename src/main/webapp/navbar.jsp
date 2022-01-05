<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <!-- Styles CSS -->
    <link rel="stylesheet" href="css/header.css">

    <link rel="shortcut icon" href="img/icons/logo.svg" type="image/x-icon">
    <title>Grezzo Soon</title>
</head>
<body>

    <!-- Header -->
    <header class="header">
        <a href="index.html" class="logo"><i class="fal fa-film" style="color: white;">GrezzoSoon</i></a>
            <nav class="nav-links">
                <ul>
                    <li><form action="index.html">
                    	<button class="my-nav-buttons">
                            <span class="icons"><svg alt="home" viewBox="0 0 36 36" style="height: 24px; min-width: 24px; width: 24px; z-index: auto;"><path d="M26.882 19.414v10.454h-5.974v-5.227h-5.974v5.227H8.961V19.414H5.227L17.921 6.72l12.694 12.694h-3.733z"></path></svg></span>
                           
                            <p class="name-tag">home</p>
						</button>
						</form>                        
                    </li>
                    <li><form action="trova-tutti-film" method="get">
                    <button class="my-nav-buttons">
                        <span class="icons"><svg alt="film" viewBox="0 0 36 36" style="height: 24px; min-width: 24px; width: 24px; z-index: auto;"><path d="M24.71 20.07a2.97 2.97 0 1 0-4.2-4.2 2.97 2.97 0 0 0 4.2 4.2m-12.262 0a2.97 2.97 0 1 0-4.2-4.2 2.97 2.97 0 0 0 4.2 4.2m6.173-10.31a2.969 2.969 0 1 0-4.199 4.198 2.969 2.969 0 0 0 4.199-4.198m0 12.262a2.969 2.969 0 1 0-4.199 4.198 2.969 2.969 0 0 0 4.199-4.198m-1.544-4.629a.846.846 0 1 0-1.197 1.196.846.846 0 0 0 1.197-1.196m18.06-.644c-3.33 6.913-8.165 9.928-11.635 11.24-2.57.971-4.762 1.178-5.949 1.208-.348.032-.698.053-1.052.053C10.287 29.25 5.25 24.213 5.25 18S10.287 6.75 16.5 6.75c6.214 0 11.25 5.037 11.25 11.25a11.19 11.19 0 0 1-2.493 7.054c2.832-1.612 5.844-4.382 8.138-9.143a.968.968 0 0 1 1.742.838"></path></svg></span>
                            
                            
                            <p class="name-tag">film</p>
                            </button>
							</form>
                    </li>
                    <li><form action="ricerca-attori" method="get">
                    <button class="my-nav-buttons">
                        <span class="icons"><svg alt="star" viewBox="0 0 36 36" style="height: 24px; min-width: 24px; width: 24px; z-index: auto;"><path d="M17.625 26.028L10.44 30l1.373-8.412L6 15.631l8.033-1.228 3.592-7.653 3.592 7.653 8.033 1.228-5.813 5.957L24.81 30z"></path></svg></span>
                            
                            
                            <p class="name-tag">attori</p>
                            </button>
							</form>
                    </li>
                </ul>
            </nav>
            
        <!-- Profile -->
        <div class="profile">
            <div class="profile-selected">
           
                <p class="name-user">Accedi</p>
            
                <img class="avatar img-user" src="img/user.svg" alt="">
            </div>
      
            <nav class="profile-nav">
                <!-- hover -->
                <ul class="profile-nav-options">
                    <li><form action="login.jsp">
                    <button class="my-nav-buttons">
                    <p>Login</p>
                    </button>
					</form></li>
                    <li><form action="registrazione.jsp">
                    <button class="my-nav-buttons"s>
                    <p>Registrati</p>
                    </button>
					</form>
				</li>
                </ul>
            </nav>
        </div>
    </header>

    <!-- SLIDER GRANDE DA METTERE-->
    
    
       
      
        
    <!-- Films -->
       
     
    <!-- Footer -->
  
</body>

</html>