<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
    <link rel="stylesheet" href="./css/siginup_style.css">
  </head>
  <body>
  <%
	//User user = (User) session.getAttribute("userSession");
	//if (user != null) {
		//response.sendRedirect("/alimama/services.jsp");
	//}
%>
    <div class="main">
      <section class="signup">
        <div class="container">
          <div class="signup-content">
            <div class="signup-form">
              <h2 class="form-title">Sign up</h2>
              <form method="post" action="/alimama/signup" class="register-form" id="register-form">
                <div class="form-group">
                  <label for="firstName">
                    <i class="fa-solid fa-user"></i>
                  </label>
                  <input type="text" name="firstName" id="firstName" placeholder="First Name" required>
                </div>
                <div class="form-group">
                  <label for="lastName">
                    <i class="fa-solid fa-user"></i>
                  </label>
                  <input type="text" name="lastName" id="firstName" placeholder="Last Name" required>
                </div>
                <div class="form-group">
                  <label for="phone">
                    <i class="fa-solid fa-phone"></i>
                  </label>
                  <input type="text" name="phone" id="phone" placeholder="Phone" required>
                </div>
                <div class="form-group">
                  <label for="email">
                    <i class="fa-solid fa-envelope"></i>
                  </label>
                  <input type="email" name="email" id="email" placeholder="Email" required>
                </div>
                <div class="form-group">
                  <label for="password">
                    <i class="fa-solid fa-lock"></i>
                  </label>
                  <input type="password" name="password" id="pass" placeholder="Password" required>
                </div>
                <div class="form-group">
                  <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" required>
                  <label for="agree-term" class="label-agree-term">
                    <span>
                      <span></span>
                    </span>I agree all statements in <a href="/alimama/term-services.html" class="term-service" target="_blank">Terms of service </a>
                  </label>
                </div>
                <div class="form-group form-button">
                  <input type="submit" name="signup" id="signup" class="form-submit" value="Register">
                </div>
              </form>
            </div>
            <div class="signup-image">
              <figure>
                <img src="./materials/images/signup-image.jpg" alt="sing up image">
              </figure>
              <a href="/alimama/signin.jsp" class="signup-image-link">I am already member</a>
            </div>
          </div>
        </div>
      </section>
    </div>
  </body>
</html>