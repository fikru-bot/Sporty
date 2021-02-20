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
<link rel="stylesheet" href="/Galery/resources/css/product-detail.css">
</head>
<body>
<div class="cat">
	<sf:form action="/Galery/bookProd" method="post"
		modelAttribute="form">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<img
							src="/Galery/prod/getImage/<c:out value='${prod.id}'/>"
							alt="Image" class="image-fluid">
					</div>
					<div class="col-md-6">
						<h2 class="text-black">${prod.name}</h2>
						<p>${prod.description}</p>
						<p>
							<strong class="text-primary h4">${prod.price}</strong>
						</p>
						<p>
							<a href="/Galery/cart?pId=${prod.id}&operation=addCart"
								class="buy-now btn btn-sm btn-primary">Add To Cart</a>
						</p>
					</div>
				</div>
			</div>
	</sf:form>
	</div>
</body>
</html>