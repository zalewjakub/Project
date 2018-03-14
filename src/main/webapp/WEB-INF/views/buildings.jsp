<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Budynki</title>
</head>
<body>
	<h2>${param.message}</h2>

	<table border="1px">
		<thead>
			<tr>
				<th>Miasto</th>
				<th>Ulica</th>
				<th>Numer</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<c:forEach items="${buildings}" var="building">
				<tr>
					<td>${building.city}</td>
					<td>${building.street}</td>
					<td>${building.number}${building.extNumber}</td>
					<td><a href="building/deleteSure/${building.id}">Usuń</a></td>
					<td><a href="building/update/${building.id}">Edytuj</a></td>
					<td><a href="building/more/${building.id}">Więcej</a></td>
				</tr>
			</c:forEach>
	</table>
	<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>