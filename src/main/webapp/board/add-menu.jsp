<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Menu</title>
</head>
<body>
<jsp:include page="../nav.html" />
<br/><br/><br/>
<%
	if (session.getAttribute("boardSession") == null) {
		response.sendRedirect("/alimama/admin");
	}
%>	
<form action="/alimama/AddMenu" method="post">

	<input type="text" name="name" placeholder="Menu Name"/>
	<input type="text" name="category" placeholder="category"/>
	<input type="number" name="price" step="0.01" placeholder="price"/>
	<input type="text" name="image" placeholder="image address"/>
	<input type="submit" value="Add">

</form>


</body>
</html>