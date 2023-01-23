<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.User"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Signin</title>
</head>
<body>
<%
	User user = (User) session.getAttribute("userSession");
	if (user != null) {
		response.sendRedirect("/alimama/services.jsp");
	}
%>
    <div>
        <form action="/alimama/signin" method="post">
            <div class="user-input">
                <div class="input">
                    <input type="text" name="email" placeholder="Email"/>
                </div>
                <div class="input">
                    <input type="password" name="password" placeholder="password"/>
                </div>
            </div>
            <div class="submit">
                <input type="submit" name="submit" value="submit">
            </div>
        </form>
        <a href="/alimama/signup.html">Sign up</a>
    </div>
</body>
</html>