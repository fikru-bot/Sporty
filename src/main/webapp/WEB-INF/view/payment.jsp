<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="com.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Galery/resources/css/payment.css">
</head>
<body>
<div class="container">
<div class="cat">
<sf:form action="/Galery/bookProd/payment" method="post"
		modelAttribute="form">
		<h2>Payment Form</h2>
				<label for="r4" id="pwd">Card No</label>
				<input type="text" placeholder="Enter Card NO"
					id="r4" />
				<br />
				<label for="r4" id="pw">Card Holder Name</label>
				<input type="text" placeholder="Enter Holder Name"
					id="r4" />
				<br />
				<label for="r4" id="pwd">Month</label>
				<input type="text" placeholder="Enter Month"
					id="r4" />
				<br />
				<label for="r4" id="pwd">Year</label>
				<input type="text" placeholder="Enter Year"
					id="r4" />
				<br />
				<label for="r4" id="pwd">CVV</label>
				<input type="password" placeholder="Enter CVV"
					id="r4" />
				<br />
				<button type="submit" value="Confirm Payment" id="button" name="operation">Confirm Payment</button>
			
	</sf:form>
	</div>
</div>
</body>
</html>