<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<style type="text/css">

      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    
</style>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title></decorator:title> </title>
<decorator:head></decorator:head>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#"><fmt:message key="app.title" /> </a>
				<div class="nav-collapse">
					<ul class="nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container">
	<spring:message code="app.title" message="app.title"></spring:message>
	<decorator:body></decorator:body>
	</div>
	<hr>
	<footer>
		<p>© Muhamad Faisal Abdillah 2012</p>
	</footer>
</body>
</html>