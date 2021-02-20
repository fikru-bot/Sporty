<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/Galery/resources/css/login.css">
</head>
<body>
		<sf:form action="/Galery/login" name="regi" modelAttribute="form" method="post"
			id="flogin">
			<h2>Login Form</h2>
			<b><%@ include file="response.jsp"%></b>
			<s:bind path="login">				
					<label for="r1" id="fn">Login Id</label>
					<sf:input type="text" path="login" placeholder="Enter Login"
						id="r1" />
					<br />			
			</s:bind>
			<s:bind path="password">
				<label for="r2" id="ln">Password</label>
				<sf:input type="password" path="password" placeholder="Enter Password"
					id="r2" />
				<br />
			</s:bind>
			<button type="submit" value="LogIn" id="button" name="operation">LogIn</button>
			<button type="submit" value="SignUp" id="button" name="operation">SignUp</button>
	</sf:form>
</body>
</html>