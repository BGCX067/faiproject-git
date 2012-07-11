<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Role Administrator</title>
</head>
<body>
<div class="row-fluid">
	<div class="span3">
	<div class="well sidebar-nav">
				<ul class="nav nav-list">
					<li class="nav-header">Role Admin</li>
					<li class="active"><a href="<%=request.getContextPath()%>/admin/role/add">Add</a></li>
				</ul>
			</div>
	</div>
	<div class="span9">
	<form:form commandName="roleCommand" cssClass="well" method="post">
		<h2>Role Form</h2>
		<form:label path="code">Code</form:label>
		<form:input path="code"/>
		<form:label path="description">Description</form:label>
		<form:textarea path="description"/>
		<br/>
		<div class="btn-group">
		<button type="submit" class="btn btn-primary">Add</button>
		<button type="reset" class="btn btn-primary">Reset</button>
		</div>
	</form:form>
	<table class="table table-striped">
		<thead>
			<tr><td colspan="4"><form method="get" class="well form-search"><input type="text" name="q" class="search-query"/><button type="submit" name="search" class="btn">Search</button> </form></td></tr>
			<tr><th>No</th><th>Code</th><th>Description</th></tr>
		</thead>
		<tbody>
			<c:forEach items="${roles}" var="role" varStatus="i">
			<tr><td>${i.count}</td><td>${role.code }</td><td>${role.description}</td><td><div class="btn-group"><a class="btn" href="#">Delete</a><a class="btn" href="#">Edit</a></div></td></tr>
			</c:forEach>
			<c:if test="${resultSize == 0 }">
			<tr><td colspan="4">0 Result</td></tr>
			</c:if>
		</tbody>
		<tfoot>
			<tr><td colspan="4">
				<div class="pagination">
					<ul>
						<li><a href="<%=request.getContextPath()+"/admin/role/add" %>/${0}/${prevIndex}">prev</a></li>
						<c:forEach begin="1" end="${numberPage}" var="i">
						<li><a href="<%=request.getContextPath()+"/admin/role/add" %>/${0}/${i}">${i}</a></li>
						</c:forEach>
						<li><a href="<%=request.getContextPath()+"/admin/role/add" %>/${0}/${nextIndex}">next</a></li>
					</ul>
				</div>
			</td></tr>
		</tfoot>
	</table>
	</div>
</div>

</body>
</html>