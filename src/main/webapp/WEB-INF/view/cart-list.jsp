<%@page import="java.util.HashMap"%>
<%@page import="io.ecommerce.galery.util.HTMLUtility"%>
<%@page import="java.util.List"%>
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
	<sf:form action="/Galery/cart/update" method="post"
		modelAttribute="form">
		<b><%@ include file="response.jsp"%></b>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Description</th>
					<th scope="col">Edit</th>
					<th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
				<%
					int i = 1;
				%>
				<c:forEach items="${list}" var="ct" varStatus="cs">
					<tr>
						<td><img
							src="/Galery/prod/getImage/<c:out value='${ct.productId}'/>"
							alt="Image" class="img-fluid"></td>
						<td>${ct.productName}</td>
						<td><input class="form-control text-center"
							name="quantity<%=i++%>" value="${ct.quantity}" /></td>
						<td>${ct.price}</td>
						<td>${ct.description}</td>
						<td><input type="submit" name="operation" value="Update"
							class="btn btn-primary btn-sm"></td>
						<td><a href="/Galery/cart?crId=${ct.id}&operation=Delete"
							class="btn btn-primary btn-sm">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					
					<td><a href="/Galery/bookProd" class="btn btn-primary btn-sm">Book</a></td>
				</tr>
			</tbody>
		</table>
	</sf:form>
</body>
</html>