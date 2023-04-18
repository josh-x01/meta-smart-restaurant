<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation</title>
    <link rel="stylesheet" href="../css/reservation.css">
</head>

<body>
<%
	if (session.getAttribute("userSession") == null) {
		response.sendRedirect("/alimama/signin.jsp?continue=http://localhost:8888/alimama/services/reservation.jsp");
	} else {
%>	

<jsp:include page="../nav.html" />
<br/><br/><br/>
    <div class="header">
        <h1>Reservations</h1>
    </div>

    <div class="container center">
        <form action="/alimama/OrderReservation" method="post">
            <div class="atr">
                <input type="date" name="date" id="date" required />
            </div>

            <div class="atr">
                <input type="time" id="time" name="time">
            </div>

            <div class="atr">
                <select name="people">
                    <option selected disabled>Party Size</option>
                    <option value="1">1 Person</option>
                    <option value="2">2 Person</option>
                    <option value="3">3 Person</option>
                    <option value="4">4 Person</option>
                    <option value="5">5 Person</option>
                    <option value="6">6 Person</option>
                </select>
            </div>
            <div>
                <button type="submit" class="btn btn-success button-success">Done</button>
                <a href="/alimama/Home.html">
                    <button type="button" class="btn btn-danger button-cancel" onclick="">Cancel</button>
                </a>
            </div>
        </form>

    </div>
    <script src="../script/reservation.js"></script>
<%} %>
</body>
</html>