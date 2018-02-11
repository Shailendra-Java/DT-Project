<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration page</title>
<style>
body {font-family: Arial;}
form{margin-top: 40px;}
* {box-sizing: border-box}
input[type=text], input[type=password] {
    width: 100%;
    padding-left: 15px;
    padding-right: 15px;
    padding-top: 5px;
    padding-bottom: 5px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}
button:hover {
    opacity:1;
}
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}
.container {
    padding: 16px;
    background:#fdfdfd;
    box-shadow: 0px 0px 18px -3px;
    border:solid 1px #777;
}
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
<form:form modelAttribute="user" action="saveRegister" method="post">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <div class="form-group">   
    <label><b>Name</b></label>
    <form:input path="name" type="text" class="form-control" placeholder="Enter name" name="name" required="true"/>
    </div>
    
    <div class="form-group">
    <label><b>Email</b></label>
    <form:input path="email" type="text" class="form-control" placeholder="Enter Email" name="email" required="true"/>
    </div>
    
    <div class="form-group">
    <label><b>Password</b></label>
    <form:input path="password" type="password" class="form-control" placeholder="Enter password" name="password" required="true"/>
    </div>
    
    <div class="form-group">
    <label><b>Address</b></label>
    <form:input path="address" class="form-control" placeholder="Enter address" name="address"  />
    </div>
    
    <div class="form-group">
    <label><b>Phone</b></label>
    <form:input path="phone" class="form-control" placeholder="Enter phone number" name="phone"  required="true"/>
    </div>
        
    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="reset" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form:form>
<%@include file="footer.jsp" %>
</body>
</html>