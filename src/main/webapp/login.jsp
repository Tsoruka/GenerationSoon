<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/form.css" />
<title>Login</title>
  <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
      integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
      crossorigin="anonymous"
    />
</head>
<body>
<section class="vh-100 gradient-custom">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card bg-dark text-white" style="border-radius: 1rem">
              <div class="card-body p-5 text-center">
                <div class="mb-md-5 mt-md-4 pb-5">
                  <h2 class="fw-bold mb-2 text-uppercase">ACCEDI</h2>
                  <p class="text-white-50 mb-5">
                    Inserisci i tuoi dati per accedere!
                  </p>

                  <div class="form-outline form-white mb-4">
                    <input
                      type="text"
                      id="username"
                      class="form-control form-control-lg"
                    />
                    <label class="form-label" for="username">Username</label>
                  </div>

                  <div class="form-outline form-white mb-4">
                    <input
                      type="password"
                      id="password"
                      class="form-control form-control-lg"
                    />
                    <label class="form-label" for="password"
                      >Password</label
                    >
                  </div>
<!--
                  <p class="small mb-5 pb-lg-2">
                    <a class="text-white-50" href="#!">Password dimenticata?</a>
                  </p>
-->
                  <button
                    class="btn btn-outline-light btn-lg px-5" type="submit">
                    Accedi
                  </button>
<!--
                  <div
                    class="d-flex justify-content-center text-center mt-4 pt-1"
                  >
                    <a href="#!" class="text-white"
                      ><i class="fab fa-facebook-f fa-lg"></i
                    ></a>
                    <a href="#!" class="text-white"
                      ><i class="fab fa-twitter fa-lg mx-4 px-2"></i
                    ></a>
                    <a href="#!" class="text-white"
                      ><i class="fab fa-google fa-lg"></i
                    ></a>
                  </div>
-->
                </div>

                <div>
                  <p class="mb-0">
                    Non hai un account?
                    <a href="#!" class="text-white-50 fw-bold">Registrati</a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
</body>
</html>