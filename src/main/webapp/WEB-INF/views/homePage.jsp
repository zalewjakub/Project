<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "/WEB-INF/views/header.jsp" %>

<h2>Najnowsze wieści</h2>
<h3>Uwaga na koty! Potrafią sie łasić</h3>
<h4>2018-03-05</h4>
<h3>Panie sprzątające proszą o nie wyrzucanie petów na trawnik</h3>
<h4>2018-03-02</h4>
<h3>Jeże wyraziły ogromny żal z powodu nocnego tupania, które obudziło wielu mieszkańców</h3>
<h4>2018-02-22</h4>
<%-- <c:forEach items="${tweets}" var = "tweet">
	<div border="1px solid darkblue">${tweet}</div>
</c:forEach> --%>
</body>
</html>