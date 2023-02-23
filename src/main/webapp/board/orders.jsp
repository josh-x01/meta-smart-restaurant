<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.alimama.data_util.servicesManager.OrderDataUtil"
    import="com.alimama.data_util.servicesManager.MenuDataUtil"
    import="com.alimama.data_util.servicesManager.OrdersManager"
    import="com.alimama.data_util.servicesManager.ReservationDataUtil"
    import="com.alimama.data_util.servicesManager.AddAddress"
    import="com.alimama.services.Order"
    import="com.alimama.services.Orders"
    import="java.util.List"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
	<style>
		th, td {
			padding: 2px 5px 2px 5px;
		}
		
		thead {
			background-color: #F0EEED;
		}
	</style>
</head>
<body>
<%
	if (session.getAttribute("boardSession") == null) {
		response.sendRedirect("/alimama/admin");
	}
%>	
<jsp:include page="../nav.html" />
<br/><br/><br/>



	<table class="orders">

			<thead>
				<tr class="title">
					<th class="titles">OID</th>
					<th class="titles">CID</th>
					<th class="titles">WID</th>
					<th class="titles">TID</th>
					<th class="titles">Price</th>
					<th class="titles">Type</th>
					<th class="titles">Time</th>
					<th class="titles">Orders</th>
					<th class="titles">Address</th>
				</tr>
			</thead>
		
		<tbody>
<%
	OrderDataUtil odu = new OrderDataUtil();
	MenuDataUtil mdu = new MenuDataUtil();
	OrdersManager om = new OrdersManager();
	ReservationDataUtil rdu = new ReservationDataUtil();
	AddAddress aa = new AddAddress();
	String address = "";
	List<Order> os = odu.getOrders();
	List<Orders> oms = om.getOrders();
	if (os != null) {
		for (Order o : os) {
%>
		<tr class="row">
				<td class="rows"><%= o.getOrderId() %></td>
				<td class="rows"><%= o.getCustomerId() %></td>
				<td class="rows"><%= o.getWaiterId() %></td>
				<td class="rows"><%= o.getTableId() %></td>
				<td class="rows"><%= o.getTotalPrice() %></td>
				<td class="rows"><%= o.getType() %></td>
				<td class="rows"><%= o.getTime() %></td>
<% if (o.getType().equals("reservation")) 
	{
		out.println("<td class='rows'>"+ rdu.getReservationTime(rdu.getReservationId(o.getOrderId())) +"</td>");
		out.println("<td class='rows'> n/a </td>");
	} else if (o.getType().equals("delivery")) {
		out.println("<td class='rows'>" + om.getOrders(o.getOrderId()) + "</td>");
		out.println("<td class='rows'>"  + aa.getAddress(o.getCustomerId()) + "</td>");
	} else {
		out.println("<td class='rows'>" + om.getOrders(o.getOrderId()) + "</td>");
		out.println("<td class='rows'> n/a </td>");
	}
%>
				
		</tr>
<%
		}
	}
%>
	</tbody>
	</table>
</body>
</html>