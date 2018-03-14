<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit book</title>

</head>
<body>
	<form method="post" action="/Project/flat/getFlats">
		<div class="col-md-4">
			Szukaj po budynku: <input type='number' name='buildingId'
				value='1' min="1" max="100" step="1"> <input type='submit'
				value="Wyślij">
		</div>

	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>