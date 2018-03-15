<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Twoje dane</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form:form modelAttribute="homeovner" method="POST" action="/Project/user">
		<h2>Dane użytkownika</h2>
		<form:hidden path="id" value="${id}" />
		<form:hidden path="password" value="${password}" />
		<form:hidden path="description" value="${description}" />
		<div class="row">
			<div class="col-md-2">Imię</div>
			<div class="col-md-3">
				<form:input path="firstName" placeholder="imie" />
				<form:errors path="firstName"></form:errors>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">Nazwisko</div>
			<div class="col-md-3">
				<form:input path="lastName" placeholder="nazwisko" />
				<form:errors path="lastName"></form:errors>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">Login</div>
			<div class="col-md-2">
				<form:input path="login" placeholder="login" />
				<form:errors path="login"></form:errors>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">Email</div>
			<div class="col-md-2">
				<form:input path="email" placeholder="email" />
				<form:errors path="email"></form:errors>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2">Numer telefonu</div>
			<div class="col-md-2">
				<form:input path="phone" placeholder="telefon" />
				<form:errors path="phone"></form:errors>
			</div>
		</div>

		<div class="row">
			 <a href="/Project/user"><input
				type="submit" value="Zapisz zmiany" /></a>
		</div>
		<div class="col-md-8">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Lokal</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${flats}" var="flats">
						<tr>
							<td>${flats.name}</td>

							<td><a href="homeovner/count/${homeovner.id}">Rozliczenie</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form:form>
	<%--  <div class="row">
			<div class="col-md-2">Ostatnie zgłoszenie</div>
			<div class="col-md-2">
				<form:textarea path="text" items="${note}" itemValue="id"
					itemLabel="text"></form:textarea>
				<form:errors path="notes"></form:errors>
			</div>
		</div> --%>
	<form:form modelAttribute="notes" action="/Project/user/addNotes"
		method="post">
		<div class="row">
			<div class="col-md-4">
				<form:textarea path="textInfo" placeholder="Wpisz zgłoszenie"/>
				<form:errors path="textInfo"></form:errors>
			</div>
			<div class="col-md-2">
				<button type="submit">
					Dodaj zgłoszenie
					<button>
			</div>
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
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>