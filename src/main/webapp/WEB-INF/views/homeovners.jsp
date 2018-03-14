<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Wlasciciele</title>
</head>
<body>
	<h2>${param.message}</h2>

	<table border="1px">
		<thead>
			<tr>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<c:forEach items="${homeovners}" var="homeovner">
				<tr>
					<td>${homeovner.firstName}</td>
					<td>${homeovner.lastName}</td>
					<td><a href="homeovner/deleteSure/${homeovner.id}">Usuń</a></td>
					<td><a href="homeovner/update/${homeovner.id}">Edytuj</a></td>
				</tr>
			</c:forEach>
	</table>
	<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>