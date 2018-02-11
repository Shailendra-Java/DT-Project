<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>e-mart</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      min-height:200px;
      max-height:500px;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  .h{color: burlywood;}
  </style>
</head>
<body>
	<%@include file="header.jsp" %>
	<div style="width: 100%; height:50px;"></div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="${images}/img1.jpg" alt="Image">     
      </div>

      <div class="item">
        <img src="${images}/img2.jpg" alt="Image">     
      </div>
    <div class="item">
        <img src="${images}/img3.jpg" alt="Image">     
      </div>
    <div class="item">
        <img src="${images}/img4.jpg" alt="Image">      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="container text-center"> 
  <h3>Today's Deal</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="${images}/kid1.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>30% off</p>
      <h3>&#x20B9; 450</h3>
      <h4 class="h">Kids dresses </h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/kid2.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>30% off</p> 
      <h3>&#x20B9; 950</h3> 
      <h4 class="h">Girl dresses </h4>  
    </div>
   <div class="col-sm-4">
      <img src="${images}/kid3.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>30% off</p>
      <h3>&#x20B9; 650</h3>
      <h4 class="h">Kids dresses </h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/men1.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>20% off</p> 
      <h3>&#x20B9; 1450</h3>   
      <h4 class="h">Men's casual shirt </h4>
    </div>
    <br>
    <div class="col-sm-4">
      <img src="${images}/men2.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>20% off</p>
      <h3>&#x20B9; 1650</h3>
      <h4 class="h">Men's printed shirt </h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/men3.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>20% off</p> 
      <h3>&#x20B9; 1299</h3>   
      <h4 class="h">Men's formal shirt </h4>
    </div>
    <div class="col-sm-4">
      <img src="${images}/w1.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>10% off</p>
      <h3>&#x20B9; 2450</h3>
      <h4 class="h">Women's night wear </h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/w2.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>10% off</p>
      <h3>&#x20B9; 1450</h3>    
      <h4 class="h">Women's gown</h4>
    </div>
    <div class="col-sm-4"> 
      <img src="${images}/w3.jpg" class="img-responsive" style="width:100%" alt="Image">
      <p>10% off</p>
      <h3>&#x20B9; 3450</h3>    
      <h4 class="h">Women's saree </h4>
    </div>
  </div>
</div><br>
	<%@include file="footer.jsp" %>
</body>
</html>
