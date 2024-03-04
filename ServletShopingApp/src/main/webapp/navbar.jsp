<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<style>
  *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
 

.navbar{
  position: fixed;
  top: 1px;
  margin: 2px;
  width: 100%;
}
#nav{
    background-color: tomato;
}

.nav-link{
  transition: all 3s;
}
.nav-link:hover{
  background-color: rgb(241, 164, 151);

  font-size: 1.1rem;
}
#user{
margin:5px;
background-color:green;
border-radius:50%;
  object-fit: cover;
}


</style>


</head>
<body>

  <div>
      <nav class="navbar navbar-expand-lg navbar-light " id="nav">
          <div class="container-fluid">
          <a class="navbar-brand text-white" href="#">SSD Ecom</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse " id="navbarNav">
            <ul class="navbar-nav  ms-auto ">
            
            <c:if test = "${user!=null}">
            
              <li class="nav-item  ">
                <a class="nav-link active text-white" aria-current="page" href="productlist">Home</a>
              </li>
              <li class="nav-item  ">
                <a class="nav-link text-white" href="product.jsp">Product</a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-white" href="./cartlistservlet"><span>${oldcartlist.size()}</span> Cart</a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-white" href="./orderlistservlet">Orders</a>
              </li>
              <li class="nav-item " id="user">
                <span><c:out value="${user.getName() }"></c:out></span>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-white" href="logout">Logout</a>
              </li>
              
              </c:if>
              
              <c:if test = "${user==null}">
              
              <li class="nav-item ">
                <a class="nav-link text-white btn" href="./login" >Login</a>
              </li>
              <li class="nav-item ">
                <a class="nav-link text-white btn" href="./signup" >Signup</a>
              </li>
              
              </c:if>
              
            </ul>
          </div>
          </div>
       </nav>
    </div>
</body>
</html>

