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
	<h2>Dane użytkownika</h2>
	<div class="row">
		<div class="col-md-1">Imię</div>
		<div class="col-md-3">${homeovner.firstName}</div>
	</div>
	<div class="row">
		<div class="col-md-1">Nazwisko</div>
		<div class="col-md-3">${homeovner.lastName}</div>
	</div>
	<div class="row">
		<div class="col-md-1">Login</div>
		<div class="col-md-2">${homeovner.login}</div>
	</div>
	<div class="row">
		<div class="col-md-1">Email</div>
		<div class="col-md-2">${homeovner.email}</div>
	</div>
	<div class="row">
		<div class="col-md-1">Telefon</div>
		<div class="col-md-2">${homeovner.phone}</div>
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
				<c:forEach items="${flat}" var="flat">
					<tr>
						<td>${flat.name}</td>

						<td><a href="/Project/homeovner/count/${homeovner.id}">Rozliczenie</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
	<form:form modelAttribute="notes" action="/Project/user" method="post">
	<div class="col-md-8">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Utworzone</th>
					<th>Treść zgłoszenia</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notes}" var="note">
					<tr>
						<td>${note.created}</td>

						<td>${note.textInfo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</form:form>
	<br />

	<a href="/Project/loggedAdmin">Powrót</a>
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
</body>
</html>