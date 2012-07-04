<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome To Web Skeleton By Faisal Abdillah</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Project name</a>
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
	<decorator:body></decorator:body>
</body>
</html>