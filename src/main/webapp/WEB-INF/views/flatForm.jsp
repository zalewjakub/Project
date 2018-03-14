<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit flat</title>

</head>
<body>
	<form:form modelAttribute="flat" method="POST"
		action="/Project/flat/add">

		<form:hidden path="id" value="${id}" />

		<div class="col-md-4">
			Budynek:
			<form:select path="building" items="${buildings}" itemValue="id"
				itemLabel="name"></form:select>
			<form:errors path="building"></form:errors>
		</div>

		<div class="col-md-4">
			Numer lokalu:
			<form:input path="number" type="number" min="1" max="200" step="1"
				value="1" />
			<form:errors path="number"></form:errors>
		</div>

		<div class="col-md-4">
			Powierzchnia:
			<form:input path="area" type="number" min="1" max="200" step="0.05"
				value="45.55" />
			<form:errors path="area"></form:errors>
		</div>

		<div class="col-md-4">
			Opis:<br />
			<form:textarea path="notes" placeholder="opis" />
			<form:errors path="notes"></form:errors>
			</div>


				 <a href="/Project/flat/add"><input type="submit"
						value="Dodaj" /></a>
	</form:form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>