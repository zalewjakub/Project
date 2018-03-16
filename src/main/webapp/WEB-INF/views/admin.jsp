<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin</title>
</head>
<body>
<h1>Panel administartora</h1>
<br></br>
		Dodawanie:
	<select id="add" name="add" onchange="location = this.value;">
		<option value="loggedAdmin">--------</option>
		<option value="adminAdd/Homeowner">Właściciela</option>
		<option value="adminAdd/Flat">Mieszkania</option>
		<option value="adminAdd/Building">Budynku</option>
	</select>
<br></br>	
	
		Edytowanie/Usuwanie:
	<select id="edit" name="edit" onchange="location = this.value;">
		<option value="loggedAdmin">--------</option>
		<option value="homeovner">Właściciela</option>
		<option value="flat">Mieszkania</option>
		<option value="building">Budynku</option>
	</select>
	
	<br></br>
		Wyszukiwanie:	
	<select id="edit" name="edit" onchange="location = this.value;">
		<option value="loggedAdmin">--------</option>
		<option value="adminSearch/Homeowner">Właściciela</option>
		<option value="adminSearch/Flat">Mieszkania</option>
		<option value="building">Budynku</option>
	</select> 
	<a href="/Project">Do strony głównej</a>
</body>
</html>