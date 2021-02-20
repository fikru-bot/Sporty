<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="com.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Galery/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Galery/resources/css/table.css">
</head>
<body>
<b><%@ include file="response.jsp"%></b>
<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Image</th>
				<th scope="col">Name</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price</th>
				<th scope="col">Description</th>
			</tr>
		</thead>
		<tbody>
			<%int i=1;%>
			<c:forEach items="${list}" var="ct" varStatus="cs">
				<tr>
					<td><img
						src="/Galery/prod/getImage/<c:out value='${ct.productId}'/>"
						alt="Image" class="img-fluid"></td>
					<td>${ct.productName}</td>
					<td>${ct.quantity}</td>
					<td>${ct.price}</td>
					<td>${ct.description}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>