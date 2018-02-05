<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
  <title>Home page</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class = "container" style="margin-top: 80px;">
<hr>
<div class = "modal fade eg-demo-model-sm" tabindex= "1" role = "dialog"
aria-lablelledby = "myModel" aria-hidden = "true" id = "onload">
<div class = "model-dialog model-lg">
<div class = "model-content">
<div class = "modal-header">
<button type = "button" class = "close" data-dismiss = "model">X</button>
</div>
<div class = "model-body"><span>Added Successfully!!!</span>
<div class = "model-footer">
<a href = "${pageContent.request.contextPath }/adding" class = "btn btn-primary" role = "button">Back</a></div>
</div>
</div>
</div>
</div>
</div>
<script type="text/javascript">
$(document.ready(function()
		{
		$('#onload').status('show');
		}
		)
</script>

</body>
</html>