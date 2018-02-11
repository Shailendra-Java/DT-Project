<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${css}/lgnreg.css">
<title>e-mart</title>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    min-width: 200px;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
    float:left;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    width:300px;
    height:89px;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
    box-shadow: 0px 0px 18px -3px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>
	<%@include file="header.jsp" %>
		<form:form name="submitForm" action="/login" method="POST">
        <div align="center" style="margin-top:70px;">
            <div class="imgcontainer">
    <img src="https://www.renault.mk/libs.cdn.renault.com/etc/designs/renault_v2/3.1.1-2/common-assets/img/avatar/avatar.png" alt="Avatar" class="avatar">
  </div></div>

  <div class="container" style="min-width: 450px; max-width: 100%; width:660px;">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        
    <label>
      <input type="checkbox" checked="checked"> Remember me
    </label>
    <button type="submit">Login</button>
  </div>

  <div class="container" style="background-color:#f1f1f1; min-width: 450px; max-width: 100%; width:660px;">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
    </form:form>
	<%@include file="footer.jsp" %>
</body>
</html>