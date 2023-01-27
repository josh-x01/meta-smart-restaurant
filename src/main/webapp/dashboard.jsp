<%@page import="com.alimama.users.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
<% 
	String password = null;
	if (request.getAttribute("password") != null) {
		password = (String) request.getAttribute("password");
	} else {
		password = (String) session.getAttribute("password");
	}
	User user = null;
	if (session.getAttribute("userSession") == null)
		response.sendRedirect("/alimama/signin.jsp");
	 else
		user = (User) session.getAttribute("userSession");
	if (user != null) {
%>
    <div>
        <form action="/alimama/update" method="post">
            <div class="user-input">
            	<input type="hidden" name="command" value="update">
                <div class="input">
                    <input type="text" name="firstName" placeholder="First Name"
                    value="<%= user.getFirstName() %>" required />
                </div>
                <div class="input">
                    <input type="text" name="lastName" placeholder="Last Name" 
                    value="<%= user.getLastName() %>" required />
                </div>
                <div class="input">
                    <input type="hidden" name="email" placeholder="Email"
                    value="<%= user.getEmail() %>" required />
                </div>
                <div class="input">
                    <input type="text" name="phone" placeholder="09 or 07 12345678" pattern="[0]{1}[7,9]{1}[0-9]{8}"
                    value="<%= user.getPhone() %>" required />
                </div>
                <div class="input">
                    <input type="password" name="password" id="password"
                    value="<%= password %>" required />
                </div>
            </div>
            <div class="form-group">
				<input type="checkbox" name="show" id="show" class="agree-term" onclick="showPassword()">
			    	<label for="agree-term" class="label-agree-term">
						<span><span></span></span>
						Show Password
			        </label>
			</div>
            <div class="submit">
                <input type="submit" name="submit" value="Update">
            </div>
        </form>
        
        <form action="/alimama/update" method="post">
			<div class="input">
				<input type="hidden" name="command" value="delete">
				<input type="hidden" name="email" placeholder="Email"
                    value="<%= user.getEmail() %>" />
				<input type="submit" name="submit" value="Delete Account">
			</div>
		</form>
    </div>
    <a href="/alimama/signout.jsp">Logout</a>
<%} %>
	<script type="text/javascript" src="./script/show.js"></script>
</body>
</html>