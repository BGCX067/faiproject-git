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
			<tr><td colspan="3"><form class="well form-search"><input type="text" name="query" class="search-query"/><button type="button" name="search" class="btn">Search</button> </form></td></tr>
			<tr><th>No</th><th>Code</th><th>Description</th></tr>
		</thead>
		<tbody>
			<tr><td>1</td><td>Test 1</td><td>Test 1</td></tr>
			<tr><td>2</td><td>Test 2</td><td>Test 2</td></tr>
			<tr><td>3</td><td>Test 3</td><td>Test 3</td></tr>
		</tbody>
		<tfoot>
			<tr><td colspan="3">
				<div class="pagination">
					<ul>
						<li><a href="#${param.q}">prev</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">next</a></li>
					</ul>
					${param.resultSize}
				</div>
			</td></tr>
		</tfoot>
	</table>
	</div>
</div>

</body>
</html>