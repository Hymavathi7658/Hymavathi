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
.form{
    margin:10%;
    margin-right: 35%;
    padding: 10%;
    height: 400px;
    border: 3px solid rgb(153, 241, 153) transparent;
    
}
.nav-link{
  transition: all 3s;
}
.nav-link:hover{
  background-color: rgb(241, 164, 151);

  font-size: 1.1rem;
}
.container{
    margin-top: 6%;

}

img{
width:100%;
height: 70%;
}

.card{
z-index:-1;
}



</style>

</head>
<body>

<%@include file="navbar.jsp"%>
   
    <div class="container "> 
       <div class="row d-flex-row justify-content-between ">
       <c:forEach var="product" items="${productList}">
       
   
        <div class="card  my-3" style="width: 18rem;">
          <img class="card-img-top" src="${product.getProductImg()}" alt="Card image cap">
        <div class="card-body">
         <h5 class="card-title">${product.getProductName()}</h5>
         <h6 class="card-title">Category: ${product.getCategory()}</h6>
         <h6 class="card-title">Price: ${product.getPrice()}</h6>
         <div class="d-flex-row justify-content-between">
         <a href="addtocart?id=${product.getId()}" class="btn btn-primary">Add to Cart</a>
         <a href="orderservlet?action=landing&id=${product.getId()}" class="btn btn-primary">Buy Now</a>
       </div>
     </div>
 
</div>

</c:forEach>

</div>
</div>

    

</body>

</html>