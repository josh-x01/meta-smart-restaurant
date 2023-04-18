<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="com.alimama.services.Menu"
    import="com.alimama.users.User"
    import="com.alimama.data_util.servicesManager.MenuDataUtil"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link rel="stylesheet" href="menu.css">
</head>
<body>

<%
	if (session.getAttribute("userSession") == null) {
		response.sendRedirect("/alimama/signin.jsp?continue=http://localhost:8888/alimama/services/menu.jsp");
	}
%>


<jsp:include page="../nav.html" />
<br/><br/><br/>
    <h1>ALIMAMA MENU</h1>
    <section>
<%
	List<Menu> menuLists = new MenuDataUtil().getMenu();
	
	if (menuLists != null) {
		out.print("<form action='/alimama/orders' method='get' >");
		out.print("<select name='type'><option value='delivery'>Delivery</option><option value='site'>At Restaurant</option></select>");
%>
		
		<div class='items'>
<%
		for (Menu m : menuLists) {
%>
        <div class="item">
            <img src="<%=m.getImage()%>">
            <h3><%=m.getName() %></h3>
            <div class="button">ETB <%=m.getPrice()%></div>
            <input type="checkbox" value="<%= m.getMenuId() %>" name="id" class="sel" onclick="checker()">
        </div>
<%
		}
		out.print("</div>");
		out.print("<input type='submit' value='Done' class='done'>");
		out.print("</form>");
	}

%>
<br/><br/><br/>
</section>

<script>
function checker() {
	  const items = document.getElementsByClassName("item");
	for (let i = 0; i < items.length; i++) {
	  if (items[i].children[3].checked) {
	    items[i].style.backgroundColor = "#F0EEED";
	    items[i].children[2].style.backgroundColor = "rgb(203, 15, 15)";
	  } else {
	    items[i].style.backgroundColor = "white";
	    items[i].children[2].style.backgroundColor = "green";
	  }
	}
	}

</script>


</body>
</html>