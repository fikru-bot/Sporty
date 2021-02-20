<%@page import="io.ecommerce.galery.entity.UserEntity"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/Galery/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Galery/resources/css/adminHome.css">
<link rel="stylesheet" href="/Galery/resources/css/welcome.css">
<body>
	<% UserEntity userbean=(UserEntity)session.getAttribute("userLogin");%>
	<header class="header_area">
		<div class="main-menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<a class="navbar-brand" href="#"><img
						src="/Galery/resources/images/add-shopping-cart.png" /></a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarNav"
						aria-controls="navbarNav" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNav">
						<div class="ms-auto"></div>
						<ul class="navbar-nav">
							<%if(userbean!=null){ %>

							<%if(userbean.getRoleId()==2){ %>
							<li class="nav-item active"><a class="nav-link"
								aria-current="page" href="#">Home</a></li>
							<li class="nav-item"><a class="nav-link"
								href="bookProd/search">Booked Products</a></li>
							<li class="nav-item"><a class="nav-link" href="login">Logout</a>
							</li>
							<%} }else{%>
							<li class="nav-item"><a class="nav-link" href="login">Login</a>
								<%}%>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<section>
		<div class="container">
			<sf:form action="/Galery/welcome" method="post" modelAttribute="form">
				<div class="row">
					<c:forEach items="${list}" var="cd" varStatus="cs">

						<div class="col-sm-4">
							<a class="block-1-item"
								href="/Galery/prod/home/search?cId=${cd.id}"> <img
								src="/Galery/category/getImage/<c:out value='${cd.id}'/>" alt=""
								class="img-fluid">
								<h3>${cd.name}</h3>
							</a>
						</div>
					</c:forEach>
				</div>
			</sf:form>

		</div>
	</section>
</body>
</html>