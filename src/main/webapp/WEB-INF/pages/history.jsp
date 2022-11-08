<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>
          History
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
                    <a class="nav-link " aria-current="page" href="/index">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/transfer">Transfer</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" href="#">Transaction History</a>
                  </li>
                  <li>
                  <li class="nav-item justify-content-end dropdown">
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
          
	<table class="table" aria-label="Transaction History Table">
            <thead>
              <tr>
                <th scope="col">Transaction Id</th>
                <th scope="col">Beneficiary Name</th>
                <th scope="col">Transaction Date</th>
                <th scope="col">Transaction Amount</th>
                <th scope="col">Transaction Type</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${transactions }" var="transaction">
                    <tr>
                        <td>${transaction.transactionId}</td>
         
                        <td>${transaction.reciever}</td>
         
                        <td>${transaction.date }</td>
         
                        <td>${transaction.amount }</td>
         
                        <td>${transaction.type}</td>
                    </tr>
                </c:forEach>
   
            </tbody>
          </table>




        <div class="hero" style="background-color: src('FrontEnd\images\hero_1.jpg');"></div>
    </body>
    
</html>
