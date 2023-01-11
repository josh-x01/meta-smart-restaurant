<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>

<%@ page import="com.meta_restaurant.test.FileHandler" %>

<% 

Blob image = null;
byte[ ] imgData = null ; 

image = new FileHandler().getBlob();

imgData = image.getBytes(1,(int)image.length());

response.setContentType("image/gif");

OutputStream o = response.getOutputStream();

o.write(imgData);

o.flush();

o.close();

%> 

