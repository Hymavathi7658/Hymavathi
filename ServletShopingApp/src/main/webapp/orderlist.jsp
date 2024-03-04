<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

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

<table class="table mt-5">
  <thead>
    <tr>
      <th scope="col">OrderedId</th>
      <th scope="col">ProductId</th>
      <th scope="col">ProductName</th>
      <th scope="col">Quantity</th>
      <th scope="col">Date</th>
      <th scope="col">ProductImg</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach var="order" items="${orderList}">
    <tr>
    <td >${order.getOrderId()}</td>
    <td >${order.getId()}</td>
      <td >${order.getProductName()}</td>
      <td>${order.getQuantity()}</td>
      <td>${order.getDate()}</td>
      <td id="img"><img alt="image" src="${order.getProductImg()}" id="image"></td>
      
    </tr>
</c:forEach>
    </tbody>
    </table>

</body>
</html>