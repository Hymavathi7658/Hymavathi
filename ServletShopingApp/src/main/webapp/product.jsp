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
body{
    background-image: url("https://img.freepik.com/free-photo/shopping-bag-cart_23-2148879372.jpg");
   background-size: cover;
    background-repeat: no-repeat;
}
.navbar{
  position: fixed;
  top: 0px;
  width: 100%;
}
#nav{
    background-color: tomato;
}
.form{
    margin:1rem;
    margin-left: 5%;
    margin-right: 35%;
    padding: 10%;
    width: 700px;
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
.form-label{
  
  
  display: flex;
  justify-content: space-around;
}
.formSection{
  border: 2px solid transparent;
  border-radius: 5px;
  
 
}
#msg{
  margin-top:60px;
  
  padding-top: 2px;
  background-color: rgb(234, 234, 191);
  font-size:1.2rem;
  text-align: center;
  color: rgb(229, 33, 33);
  border-radius: 1rem;

}


</style>


</head>
<body>

  <%@include file="navbar.jsp"%>
     

    <div  class="form">
    <c:if test = "${isValidation}">
<div class="msg">
<h1 id="msg"><c:out value = "${errormsg}"/></h1>
</div>
</c:if>
    <form  class="formSection " action="./product"  method="post">
        <div class="form-group mx-5 ">
            <label for="ProductName">Product Name</label>
            <input type="text" class="form-control"  name="ProductName" id="productName" placeholder="Enter name" required><br>
            
            <label for="Category">Category</label>
            <input type="text" class="form-control" name="Category" id="category"  placeholder="Enter category" required><br>

          <label for="Price">Price</label>
          <input type="currency" class="form-control" name="Price" id="price" placeholder="Enter price" required><br>

          <label for="ProductImg">Product Img</label>
          <input type="text" class="form-control" name="ProductImg" id="productImg" placeholder="Enter image" required><br>
          
       
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>



    
</body>
</html>