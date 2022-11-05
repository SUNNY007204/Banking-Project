<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            AWS 
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    </head>
    <body>
       
        
        <nav class="navbar navbar-expand-lg text-bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">AWS</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse "  id="navbarSupportedContent">
                <ul class="navbar-nav mb-2 mb-lg-0 nav-pills">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/transfer">Transfer</a>
                  </li>
                  <li class="nav-item dropdown justify-content-end">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${username}
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#">Account Details</a></li>
                      <li><a class="dropdown-item" href="#">Settings</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="/logout">Logout</a></li>
                      
                 
                    </ul>
                  </li>
                </ul>
              </div>
            </div>
          </nav>	
        <div class="hero" style="background-color: src('FrontEnd\images\hero_1.jpg');"></div>
        
	<div><p style = color:blue> ${status}</p></div>
    </body>
    
</html>