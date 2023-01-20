<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>

<%@ page import="com.alimama.test.FileHandler" %>

<%
Blob image  = new FileHandler().getImage();

byte[ ] imgData = image.getBytes(1,(int)image.length());

response.setContentType("image/gif");

OutputStream o = response.getOutputStream();

o.write(imgData);

o.flush();

o.close();
%> 

