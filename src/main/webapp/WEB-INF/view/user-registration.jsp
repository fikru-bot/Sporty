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
<link rel="stylesheet" href="/Galery/resources/css/registration.css">
</head>
<body>
		<sf:form action="/Galery/signUp" name="regi" modelAttribute="form" method="post"
			id="flogin">
			<h2>Registration Form</h2>
			<b><%@ include file="response.jsp"%></b>
			<s:bind path="firstName">				
					<label for="r1" id="fn">First Name</label>
					<sf:input type="text" path="firstName" placeholder="Enter First Name"
						id="r1" />
					<br />			
			</s:bind>
			<s:bind path="lastName">
				<label for="r2" id="ln">Last Name</label>
				<sf:input type="text" path="lastName" placeholder="Enter Last Name"
					id="r2" />
				<br />
			</s:bind>
			<s:bind path="login">
				<label for="r3" id="un">Login Id</label>
				<sf:input type="text" path="login" placeholder="Enter Login Id"
					id="r3" />
				<br />
			</s:bind>
			<s:bind path="password">
				<label for="r4" id="pwd">Password</label>
				<sf:input type="password" path="password" placeholder="Enter Password"
					id="r4" />
				<br />
			</s:bind>
			<s:bind path="confirmPassword">
				<label for="r5" id="em">Confirm Password</label>
				<sf:input type="password" path="confirmPassword" placeholder="Confirm Password"
					id="r5" />
				<br />
			</s:bind>
			<s:bind path="dob">
				<label for="r6" id="mn">Date Of Birth</label>
				<sf:input type="text" path="dob" placeholder="Enter DOB"
					id="r6" />
				<br />
			</s:bind>
			<s:bind path="mobileNo">
				<label for="r7" id="ps">Mobile No</label>
				<sf:input type="text" path="mobileNo" placeholder="Enter Mobile No"
					id="r7" />
				<br />
			</s:bind>
			<s:bind path="gender">
				<label for="r8" id="cy">Gender</label>
				<sf:select type="text" name="ct" path="gender" placeholder="Enter Gender"
					id="r8" >
					<sf:option value="Male"/>
					<sf:option value="Female"/>
				</sf:select>
				<br />
			</s:bind>
			<button type="submit" value="Save" id="button" name="operation">Save</button>
			<button type="submit" value="Reset" id="button" name="operation">Reset</button>
	</sf:form>
</body>
</html>