<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edycja właściciela</title>

</head>
<body>
	<form:form modelAttribute="homeovner" method="POST"
		action="/Project/homeovner/add">
		<div class="col-md-4">
			<form:input path="firstName" placeholder="imie" />
			<form:errors path="firstName"></form:errors>
		</div>
		<div class="col-md-4">
			<form:input path="lastName" placeholder="nazwisko" />
			<form:errors path="lastName"></form:errors>
		</div>
		<div class="col-md-4">
			<form:input path="email" placeholder="email" />
			<form:errors path="email"></form:errors>
		</div>
		<div class="col-md-4">
			<form:input path="phone" placeholder="telefon" />
			<form:errors path="phone"></form:errors>
		</div>
		<div class="col-md-4">
			<form:select path="flats" items="${flats}" itemValue="id"
				itemLabel="name"></form:select>
			<form:errors path="flats"></form:errors>
		</div>
		<form:hidden path="id" value="${id}" />
		<form:hidden path="login" value="${login}" />
		<form:hidden path="password" value="${password}" />
		<div class="col-md-4">
			Opis<br />
			<form:textarea path="description" placeholder="opis" />
			<form:errors path="description"></form:errors>
		</div>
		<br />
		<a href="/Project/homeovner/add"><input type="submit"
			value="Dodaj" /></a>
	</form:form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>