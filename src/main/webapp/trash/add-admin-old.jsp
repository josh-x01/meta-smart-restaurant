<% @page import="com.alimama.users.Board" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Admin</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    />
    <link rel="stylesheet" href="../css/siginup_style.css" />
  </head>
  <body>
  
<%
	Board board = (Board)session.getAttribute("boardSession");
	
	if (board.getEmail() != "eyasuyid@gmail.com") {
		response.sendRedirect("/alimama/board/admin.jsp");
	} else {
%>
    <div class="main">
      <section class="signup">
        <div class="container">
          <div class="signup-content">
            <div class="signup-form">
              <h2 class="form-title">Admin</h2>
              <form
                method="post"
                action="/alimama/admin"
                class="register-form"
                id="register-form"
              >
              <input type="hidden" name="admin-manager" value="signup">
                <div class="form-group">
                  <label for="firstName"><i class="fa-solid fa-user"></i></label
                  ><input
                    type="text"
                    name="firstName"
                    id="firstName"
                    placeholder="First Name"
                  />
                </div>
                <div class="form-group">
                  <label for="lastName"><i class="fa-solid fa-user"></i></label
                  ><input
                    type="text"
                    name="lastName"
                    id="firstName"
                    placeholder="Last Name"
                  />
                </div>
                <div class="form-group">
                  <label for="phone"><i class="fa-solid fa-phone"></i></label
                  ><input
                    type="text"
                    name="phone"
                    id="phone"
                    placeholder="Phone"
                  />
                </div>
                <div class="form-group">
                  <label for="email"><i class="fa-solid fa-envelope"></i></label
                  ><input
                    type="email"
                    name="email"
                    id="email"
                    placeholder="Email"
                  />
                </div>
                <div class="form-group">
                  <label for="password"><i class="fa-solid fa-lock"></i></label
                  ><input
                    type="password"
                    name="password"
                    id="pass"
                    placeholder="Password"
                  />
                </div>
               <div class="form-group">
                  <label for="title"></label
                  ><input
                    type="text"
                    name="title"
                    id="title"
                    placeholder="Job Title"
                  />
                </div>
                <div class="form-group form-button">
                  <input
                    type="submit"
                    name="signup"
                    id="signup"
                    class="form-submit"
                    value="Register"
                  />
                </div>
              </form>
            </div>
            <div class="signup-image">
              <figure>
                <img
                  src="../materials/images/signup-image.jpg"
                  alt="sing up image"
                />
              </figure>
            </div>
          </div>
        </div>
      </section>
    </div>
<%}%>
  </body>
</html>
