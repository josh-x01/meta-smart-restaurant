<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="com.alimama.services.Menu"
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
<jsp:include page="../nav.html" />
<br/><br/><br/>
    <h1>ALIMAMA MENU</h1>
    <section>

<%
	List<Menu> menuLists = new MenuDataUtil().getMenu();
	
	if (menuLists != null) {
		out.print("<form action='/alimama/orders' method='get' class='items' >");
		for (Menu m : menuLists) {
%>
        <div class="item">
            <img src="<%=m.getImage()%>">
            <h3><%=m.getName() %></h3>
            <button>ETB <%=m.getPrice()%></button>
            <input type="checkbox" >
        </div>
<%
		}
		out.print("</form>");
	}

%>

</section>

</body>
</html>