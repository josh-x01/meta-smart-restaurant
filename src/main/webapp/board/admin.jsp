<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.User"%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Admin</title>

<!-- Font Icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<!-- Main css -->
<link rel="stylesheet" href="../css/signin_style.css">
</head>
<body>
<%
	User user = (User) session.getAttribute("userSession");
	if (user != null) {
		response.sendRedirect("/alimama/board/admin-page.jsp");
	}
%>

	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<h1 class="header">Alimama Board</h1>
				<div class="signin-content">

					<div class="signin-image">
						<figure>
							<img src="../materials/images/signin-image.jpg" alt="sing up image" width="500">
							<a href="/alimama/board/add-admin.html" class="signup-image-link">Add Admin</a>
						</figure>
					</div>
					<div class="signin-foworm">
						<h2 class="form-title">Admin</h2>
						<form method="post" action="/alimama/admin" class="register-form" id="login-form">
							<input type="hidden" name="admin-manager" value="signin">
							<div class="form-group">
								<label for="email"><i class="fa-solid fa-envelope"></i></label> <input type="text" name="email" id="email" placeholder="Email">
							</div>
							<div class="form-group">
								<label for="password"><i class="fa-solid fa-lock"></i></label> <input type="password" name="password" id="password" placeholder="Password">
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin" class="form-submit" value="Log in">
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>