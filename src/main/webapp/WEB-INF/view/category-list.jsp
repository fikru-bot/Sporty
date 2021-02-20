<%@page import="io.ecommerce.galery.entity.UserEntity"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="com.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/Galery/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Galery/resources/css/table.css">
<body>
<b><%@ include file="response.jsp"%></b>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Image</th>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Edit</th>
				<th scope="col">Remove</th>
			</tr>
		</thead>
		<tbody>	
			<c:forEach items="${list}" var="ct" varStatus="cs">
				<tr>
					<td><img
						src="/Galery/category/getImage/<c:out value='${ct.id}'/>"
						alt="Image" class="img-fluid"></td>
					<td>${ct.name}</td>
					<td>${ct.description}</td>
					<td><a href="/Galery/category?id=${ct.id}"
						class="btn btn-primary btn-sm">Edit</a></td>
					<td><a
						href="/Galery/category/search?cidd=${ct.id}&operation=Delete"
						class="btn btn-primary btn-sm">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>