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

.form{
    margin:10%;
    margin-right: 35%;
    padding: 10%;
    height: 400px;
    border: 3px solid rgb(153, 241, 153) transparent;
    
}


.form-label{
  
  
  display: flex;
  justify-content: space-around;
}
.formSection{
  border: 2px solid transparent;
  border-radius: 5px;
}
#main{ 
background-color: rgb(30, 30, 241);

  
}

</style>


</head>
<body>
          <%@include file="navbar.jsp"%>

  

    <div  class="form">
        <form   class="formSection py-5 ">
          <fieldset class="form-label ">
         
             <a class="nav-link text-white btn" id="main" href="./login" >Login</a>
            
            <a class="nav-link text-white btn" id="main" href="./signup" >Signup</a>

          </fieldset>
          </form>
          



    </div>



    
</body>
</html>

