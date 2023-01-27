<%@page import="com.alimama.users.Board" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
</head>
<body>
<%
	Board board = null;
	String password = (String) session.getAttribute("password");
	if (session.getAttribute("boardSession") == null)
		response.sendRedirect("/alimama/board/admin.jsp");
	 else {
		 if (request.getAttribute("password") != null) {
			 password = (String) request.getAttribute("password");
		 }

		 board = (Board) session.getAttribute("boardSession");
		 if (request.getAttribute("board") != null)
			 board = (Board) request.getAttribute("board");
	 } 
	if (board != null) {
%>
    <div>
        <form action="/alimama/admin" method="post">
            <div class="board-input">
            	<input type="hidden" name="admin-manager" value="update">
                <div class="input">
                    <input type="text" name="firstName" placeholder="First Name"
                    value="<%= board.getFirstName() %>" required />
                </div>
                <div class="input">
                    <input type="text" name="lastName" placeholder="Last Name" 
                    value="<%= board.getLastName() %>" required />
                </div>
                <div class="input">
                    <input type="hidden" name="email" placeholder="Email"
                    value="<%= board.getEmail() %>" />
                </div>
                <div class="input">
                    <input type="text" name="phone" placeholder="09 or 07 12345678" pattern="[0]{1}[7,9]{1}[0-9]{8}"
                    value="<%= board.getPhone() %>" required />
                </div>
                <div class="input">
                    <input type="password" id="password" name="password" placeholder="password"
                    value="<%= password %>"required />
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
                <input type="submit" name="submit" value="Update"/>s
            </div>
        </form>
    </div>
    <a href="/alimama/board/signout.jsp">Logout</a>
<%} %>

	<script type="text/javascript" src="../script/show.js"></script>
</body>
</html>