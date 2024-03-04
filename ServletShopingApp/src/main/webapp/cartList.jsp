<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet">
<style >
.amount{
margin-top:10%;

}
table{
margin-top:3%;

}
#txt{
width:25%;
}
#image{
width:15%;
border-radius:50%;

}
#img{
width:20%;
}


</style>

</head>
<body>

<%@include file="navbar.jsp" %>
<div class="amount">
  <h1>TotalPrice: ${totalPrice }</h1>
  </div>
<table class="table">
  <thead>
    <tr>
    <th scope="col">productImage</th>
      <th scope="col">productname</th>
      <th scope="col">category</th>
      <th scope="col">price</th>
      <th scope="col">Buynow</th>
      <th scope="col">Remove</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach var="product" items="${cartList}">
    <tr>
       <td id="img"> <img alt="image" src="${product.getProductImg()}"  id="image"></td>
      <td >${product.getProductName()}</td>
      <td>${product.getCategory()}</td>
      <td>${product.getPrice()}</td>
      <td  id="txt">
      <form action="" method="post">
  <div class="form-group d-flex justify-content-between">
  <a href="quantity-ince-dece?action=inc&id=${product.getId()}" class="btn btn-sm btn-incre"> 
  <i class="fas fa-plus-square"></i></a>
    <input type="text" name="Quantity" readonly class="form-control " id="Quantity" value="${product.getQuantity()}">
  <c:if test = "${product.getQuantity()>=1}">
  <a href="quantity-ince-dece?action=dec&id=${product.getId()}" class="btn btn-sm btn-decre"> 
  <i class="fas fa-minus-square"></i></a>
  </c:if>
  <a href="orderservlet?quantity=${product.getQuantity()}&id=${product.getId()}" class="btn btn-primary mb-2">Buy</a>
  </div>
</form> 
      </td>
      <td><a href="removeservlet?id=${product.getId()}" class="btn btn-primary mb-2">Remove</a></td>
    </tr>
</c:forEach>
    </tbody>
    </table>
</body>


</html>