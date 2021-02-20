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
<link rel="stylesheet" href="/Galery/resources/css/product-list.css">
</head>
<body>
<div class="cat">
	<sf:form action="/Galery/prod" modelAttribute="form" method="post"
		enctype="multipart/form-data">
		<h2>Add Product</h2>
		<b><%@ include file="response.jsp"%></b>
		<s:bind path="categoryId">
			<label for="r1" id="fn">Category Name</label>
			<sf:select path="categoryId" id="g6">
				<sf:options itemLabel="name" itemValue="id" items="${catList}"/>
			</sf:select>
			<br />
		</s:bind>
		<s:bind path="name">
			<label for="r1" id="fn">Name</label>
			<sf:input type="text" path="name" placeholder="Enter Name" id="r1" />
			<br />
		</s:bind>
		<s:bind path="image">
			<label for="r2" id="ln">Image</label>
			<sf:input type="file" path="image" id="r2" />
			<br />
		</s:bind>
		<s:bind path="price">
			<label for="r1" id="fn">Price</label>
			<sf:input type="text" path="price" placeholder="Enter Price" id="r1" />
			<br />
		</s:bind>
		<s:bind path="description">
			<label for="r2" id="ps">Description</label>
			<sf:textarea type="text" path="description"
				placeholder="Enter Description" id="r3" />
			<br />
		</s:bind>
		<button type="submit" value="Save" id="button" name="operation">Save</button>
		<button type="submit" value="Reset" id="button" name="operation">Reset</button>
	</sf:form>
	</div>
</body>
</html>