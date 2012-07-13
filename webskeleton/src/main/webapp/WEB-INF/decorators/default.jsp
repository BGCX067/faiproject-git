<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" type="text/css" />
	<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
</style>
<link
	href="<c:url value='/resources/css/bootstrap-responsive.min.css' />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.7.2.min.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title></decorator:title></title>
<decorator:head></decorator:head>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
					class="brand" href="#" title='<fmt:message key="app.description" />'><fmt:message key="app.title" /> </a>

				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" href="#" data-toggle="dropdown">
					
						<i class="icon-wrench"></i> Muhamad Faisal Abdillah<span class="caret"></span> </a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="icon-user"></i>Profile</a>
						</li>
						<li><a href="#"><i class="icon-envelope"></i>Notification <span class="badge badge-important">10</span></a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="icon-off"></i>Logout</a>
						</li>
						<li onclick="return false;">
					<form action="<%=request.getContextPath() %>/j_spring_security_check" method="POST" class="well" >
								<label>Email</label>
								<input type="text" placeholder="Email" name="j_username"/>
								<label>Password</label>
								<input type="Password" placeholder="Password" name="j_password"/>
								<button class="btn" type="submit"><i class="icon-briefcase"></i>Login</button>
					</form>
						</li>
					</ul>
					
				</div>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="<%=request.getContextPath()%>"><fmt:message key="app.menu.home" /></a></li>
						<li><a href="#about"><fmt:message key="app.menu.about" /></a></li>
						<li><a href="#contact"><fmt:message key="app.menu.contact" /></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<ul class="breadcrumb">
		<li>Test 1</li>
		<li>Test 2</li>
		<li>Test 3</li>
	</ul>
	<div class="container-fluid">
		<decorator:body></decorator:body>
	</div>
	<hr>
	<footer>
		<p>© <fmt:message key="app.author" /> <fmt:message key="app.year" /></p>
	</footer>
	<!-- 
	<div class="subnav navbar-fixed-bottom">
		<div class="navbar-inner">
		</div>
	</div>
	 -->
	<script type="text/javascript">
		$('.dropdown-menu').find('form').click(function(e){
			e.stopPropagation();
		});
	</script>
</body>
</html>