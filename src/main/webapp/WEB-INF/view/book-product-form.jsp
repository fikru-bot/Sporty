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
<link rel="stylesheet" href="/Galery/resources/css/book-product.css">
</head>
<body>
	<sf:form action="/Galery/bookProd" method="post" modelAttribute="form">
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
				<c:forEach items="${list}" var="ct" varStatus="cs">
					<tr>
						<td><img
							src="/Galery/prod/getImage/<c:out value='${ct.productId}'/>"
							alt="Image" class="img-fluid"></td>
						<td>${ct.productName}</td>
						<td>${ct.quantity}</td>
						<td>${ct.price}</td>
						<td>${ct.description}</td>
				</c:forEach>
			</tbody>
		</table>
		<h3>Fill the form and procced to payment</h3>
		<s:bind path="name">
			<label for="r1" id="fn">Name</label>
			<sf:input type="text" path="${status.expression}" placeholder="Enter Name"
				id="r1" />
			<br />
		</s:bind>
		<s:bind path="emailId">
			<label for="r2" id="ln">Email Id</label>
			<sf:input type="text" path="${status.expression}" placeholder="Enter Email"
				id="r2" />
			<br />
		</s:bind>
		<s:bind path="mobileNo">
			<label for="r3" id="un">Mpbile No</label>
			<sf:input type="text" path="${status.expression}" placeholder="Enter Mobile No"
				id="r3" />
			<br />
		</s:bind>
		<s:bind path="country">
			<label for="r4" id="pwd">Country</label>
			<sf:input type="text" path="${status.expression}"
				placeholder="Enter Country" id="r4" />
			<br />
		</s:bind>
		<s:bind path="state">
			<label for="r5" id="em">State</label>
			<sf:input type="text" path="${status.expression}"
				placeholder="Enter State" id="r5" />
			<br />
		</s:bind>
		<s:bind path="district">
			<label for="r6" id="mn">District</label>
			<sf:input type="text" path="${status.expression}" placeholder="Enter District" id="r6" />
			<br />
		</s:bind>
		<s:bind path="pinCode">
			<label for="r7" id="ps">Pin Code</label>
			<sf:input type="text" path="${status.expression}" placeholder="Enter Pin Code"
				id="r7" />
			<br />
		</s:bind>
		<s:bind path="address">
			<label for="r7" id="ps">Address</label>
			<sf:input type="text" path="${status.expression}" placeholder="Enter Address"
				id="r7" />
			<br />
		</s:bind>
		<button type="submit" value="Payment" id="button" name="operation">Payment</button>
		<button type="submit" value="Cancel" id="button" name="operation">Cancel</button>
	</sf:form>
</body>
</html>