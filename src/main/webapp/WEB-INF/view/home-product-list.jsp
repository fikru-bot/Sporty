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
<link rel="stylesheet" href="/Galery/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Galery/resources/css/home-product.css">
</head>
<body>
<section>
<div class="container">
<b><%@ include file="response.jsp"%></b>
<sf:form action="/Galery/prod/home/search" method="post" modelAttribute="form">
<% UserEntity userbean=(UserEntity)session.getAttribute("userLogin");%>   
<div class="row mb-5">
<c:forEach items="${list}" var="pd" varStatus="cs">
              <div class="col-sm-6 col-lg-4 mb-4" data-aos="fade-up">
                <div class="block-4 text-center border">
                  <figure class="block-4-image">
                  <%if(userbean!=null){ %>	
                  	<%if(userbean.getRoleId()==2){ %>
                    <a href="/Galery/prod/detail?pid=${pd.id}"><img src="/Galery/prod/getImage/<c:out value='${pd.id}'/>" alt="Image placeholder" class="img-fluid"></a>
                 	<%}else{ %>
                 	<img src="/Galery/prod/getImage/<c:out value='${pd.id}'/>" alt="Image placeholder" class="img-fluid">
                 	<%} %>
                 	<%}else{ %>
                 	<a href="/Galery/login?pid=${pd.id}"><img src="/Galery/prod/getImage/<c:out value='${pd.id}'/>" alt="Image placeholder" class="img-fluid"></a>
                 	<%} %>
                  </figure>
                  <div class="block-4-text p-4">
                    <h3><a href="/Galery/prod/detail?pid=${pd.id}">${pd.name}</a></h3>
                    <p class="mb-0">${pd.description}</p>
                    <p class="text-primary font-weight-bold">${pd.price}</p>
                  </div>
                </div>
              </div>
              
       </c:forEach>
</div>
</sf:form>
</div>
</section>
</body>
</html>