<%@page import="io.ecommerce.galery.entity.UserEntity"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
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
<link rel="stylesheet" href="/Galery/resources/css/com.css">
<body>
	<%
		UserEntity userbean = (UserEntity) session.getAttribute("userLogin");
	%>
	<header class="header_area">
		<%
			if (userbean != null) {
		%>
		<%
			if (userbean.getRoleId() == 1) {
		%>
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
							<li class="nav-item active"><a class="nav-link"
								aria-current="page" href="/Galery/adminheader">Home</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/category">Add Catagory</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/category/search">Catagory List</a></li>
							<li class="nav-item"><a class="nav-link" href="/Galery/prod">Add
									Product</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/prod/search">Product List</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/bookProd/search">Purchased List</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/login">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<%
			}
		%>
		<%
			}
		%>
		<%
			if (userbean != null) {
		%>
		<%
			if (userbean.getRoleId() == 2) {
		%>
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
							<li class="nav-item active"><a class="nav-link"
								aria-current="page" href="/Galery/userheader">Home</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/bookProd/search">Booked Products</a></li>
							<li class="nav-item"><a class="nav-link"
								href="/Galery/login">Logout</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<%
			}
		%>
		<%
			}
		%>
	</header>
</body>
</html>




