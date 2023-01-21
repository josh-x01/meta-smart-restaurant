<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.alimama.users.User"%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign in</title>

<!-- Font Icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Main css -->
<link rel="stylesheet" href="./css/signin_style.css">
</head>
<body>
<%
	User user = (User) session.getAttribute("userSession");
	if (user != null) {
		response.sendRedirect("/alimama/services.jsp");
	}
%>
	
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<h1 class="header">WELLCOME TO ALIMAMA</h1>
				<div class="signin-content">
					
					<div class="signin-image">
						<figure>
							<img src="./materials/images/signin-image.jpg" alt="sing up image" width="500">
						</figure>
						<a href="/alimama/signup.html" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						

						<h2 class="form-title">Sign in</h2>
						<form method="post" action="/alimama/signin" class="register-form" id="login-form">
							<div class="form-group">
								<label for="email"><i class="fa-solid fa-envelope"></i></label> <input type="text" name="email" id="email" placeholder="Email">
							</div>
							<div class="form-group">
								<label for="password"><i class="fa-solid fa-lock"></i></label> <input type="password" name="password" id="password" placeholder="Password">
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me" class="agree-term"> <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin" class="form-submit" value="Log in">
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i class="display-flex-center zmdi-facebook fa-brands fa-facebook"></i></a></li>
								<li><a href="#"><i class="display-flex-center zmdi-twitter fa-brands fa-twitter"></i></a></li>
								<li><a href="#"><i class="display-flex-center zmdi-google fa-brands fa-google"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>

	</div>

</body>
</html>