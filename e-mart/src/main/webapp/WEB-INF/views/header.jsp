<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/assets/css" />
<spring:url var="images" value="/assets/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="${css}/emart-styles.css">
<head>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-custom navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${contextRoot}/index"><span><img src="${images}/emart.png" class="logo"/></span></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextRoot}/index"><span class="glyphicon glyphicon-home"></span>  Home</a></li>
        <li><a href="${contextRoot}/admin/adding">Admin</a></li>
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin List<span class="caret"></span></a>
    
    <ul class="dropdown-menu">
    <li><a href="${contextRoot}/admin/productList">Product</a></li>
    <li><a href="${contextRoot}/admin/supplierList">Supplier</a></li>
    <li><a href="${contextRoot}/admin/categoryList">Category</a></li>
    </ul>
    </li> 
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <c:forEach var="catVAL" items="${catList}">
<<<<<<< HEAD
    			<li><a href="${contextRoot}/productCustList?cid=${catVal.cid}">${catVal.cname}</a></li>
=======
    			<li><a href="${pageContext.request.contextPath}/productCustList?cid=${catVal.cid}">${catVal.cname}</a></li>
>>>>>>> 635e33e1da1e42670cc27011c53d8bfcd012f5aa
    
    		</c:forEach>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
     <c:if test="${pageContext.request.userPrincipal.name==null }">
    	<li><a href = "${pageContext.request.contextPath }/goToRegister">Register</a></li>
    	<li><a href = "${pageContext.request.contextPath }/getLogin">Login</a></li>
    </c:if>
    
    <c:if test="${pageContext.request.userPrincipal.name!=null }">
    <li><a href = "${pageContext.request.contextPath }/logout">Logout</a></li>
    </c:if>
      </ul>
    </div>
  </div>
</nav>
</body>
</html>