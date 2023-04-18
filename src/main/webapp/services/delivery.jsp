<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery</title>
</head>
<body>
<jsp:include page="../nav.html" />
<br/><br/><br/>

<%
	if (session.getAttribute("userSession") == null) {
		response.sendRedirect("/alimama/signin.jsp?continue=http://localhost:8888/alimama/services/delivery.jsp");
	} else {
%>	

<h1>Delivery beta</h1>

<form method="post" action="/alimama/OrderDelivery">
	<input type="text" name="address" placeholder="address">
	<input type="submit" value="submit">
</form>

<h2>After you put your address select items from the menu</h2>
<%} %>
</body>
</html>