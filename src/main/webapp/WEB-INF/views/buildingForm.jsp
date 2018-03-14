<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dodaj budynek</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<form:form modelAttribute="building" method="POST"
		action="/Project/building/add">
		<form:hidden path="id" value="${id}" />

		<div class="col-md-4">
			<form:input path="city" placeholder="miasto" type="text" />
			<form:errors path="city"></form:errors>
		</div>
		<div class="col-md-4">
			<form:input path="street" placeholder="ulica" type="text" />
			<form:errors path="street"></form:errors>
		</div>

		<div class="col-md-4">
			<form:input path="number" type="number" min="1" max="200" step="1"
				value="50" />
			<form:errors path="number"></form:errors>
		</div>

		<div class="col-md-4">
			<form:input path="extNumber" placeholder="dodatek do numeru budynku"
				type="text" />
			<span class="help-block"><br />np. A, C, /1, F4</span>
			<form:errors path="extNumber"></form:errors>
		</div>

		<div class="col-md-4">
			<form:textarea path="notes" placeholder="notatki" />
			<form:errors path="notes"></form:errors>
		</div>

		<div class="col-md-4">
			<a href="/Project/building/add"><input type="submit"
				value="Dodaj"></a>
		</div>
	</form:form>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>