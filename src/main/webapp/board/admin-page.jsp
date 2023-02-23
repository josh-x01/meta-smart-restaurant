<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.Board"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>
<jsp:include page="../nav.html" />
<br/><br/><br/>
<%
	Board board = (Board) request.getAttribute("board");
	if (board != null) {
		session.setAttribute("boardSession", board);
		session.setAttribute("password", request.getAttribute("password"));
		session.setMaxInactiveInterval(60*60*60*24);
	}

	if (session.getAttribute("boardSession") == null) {
		response.sendRedirect("/alimama/board/admin.jsp");
	} else {
%>		

 <h1>This is your Admin page</h1>
 

 <a href="/alimama/board/admin-dashboard.jsp">Dashboard</a>
 <a href="/alimama/board/add-admin.jsp">Add Admin</a>
  <a href="/alimama/board/add-menu.jsp">Add menu</a>
    <a href="/alimama/board/orders.jsp">Orders</a>
<%}%>


</body>
</html>