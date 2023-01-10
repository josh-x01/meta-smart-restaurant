<%@ page import="com.meta_restaurant.users.User" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Dashboard</title>
</head>
<body>
	<h1>THis is user dashboard</h1>
	<%= ((User) request.getAttribute("user")).getEmail() %>
</body>
</html>