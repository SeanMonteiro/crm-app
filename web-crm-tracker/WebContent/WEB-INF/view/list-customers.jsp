<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Spring Form Tag Library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- JSTL Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
<link type="text/css" rel="stylesheet" href="${ pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h3>CRM - Customer Relationship Manager</h3>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- Add Customer Button here -->
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
			<!-- Customer Table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- Loop over and print customers -->
				<c:forEach var="customer" items="${customers}">
					
					<!-- construct an update link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id }"></c:param>
					</c:url>
					<tr>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>
						<!-- Display the update Link -->
						<td><a href="${updateLink }">Update</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>