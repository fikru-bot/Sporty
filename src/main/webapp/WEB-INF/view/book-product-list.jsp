<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<th scope="col">Name</th>
				<th scope="col">Product Name</th>
				<th scope="col">Email Id</th>
				<th scope="col">Mobile No</th>
				<th scope="col">Country</th>
				<th scope="col">State</th>
				<th scope="col">City</th>
				<th scope="col">Pin Code</th>
				<th scope="col">Booking Date</th>
				<th scope="col">Address</th>
				<th scope="col">Quantity</th>
				<th scope="col">Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="bp" varStatus="cs">
				<tr>
					<td><c:out value="${bp.name}" /></td>
					<td><c:out value="${bp.productName}" /></td>
					<td><c:out value="${bp.emailId}" /></td>
					<td><c:out value="${bp.mobileNo}" /></td>
					<td><c:out value="${bp.country}" /></td>
					<td><c:out value="${bp.state}" /></td>
					<td><c:out value="${bp.district}" /></td>
					<td><c:out value="${bp.pincode}" /></td>
					<td><fmt:formatDate pattern="MM/dd/yyyy" value="${bp.date}" /></td>
					<td><c:out value="${bp.address}" /></td>
					<td><c:out value="${bp.quantity}" /></td>
					<td><c:out value="${bp.anmount}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>