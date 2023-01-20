//package com.meta_restaurant.mail;
//
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//import com.mysql.cj.protocol.Message;
//
//import jakarta.websocket.Session;
//
//public class Mailing {
//
//	 public static void main(String[] args) {
//
//	 String to="divyasundarsahu@gmail.com";//change accordingly
//
//	//Get the session object
//	  Properties props = new Properties();
//	  props.put("mail.smtp.host", "smtp.gmail.com");
//	  props.put("mail.smtp.socketFactory.port", "465");
//	  props.put("mail.smtp.socketFactory.class",
//	            "javax.net.ssl.SSLSocketFactory");
//	  props.put("mail.smtp.auth", "true");
//	  props.put("mail.smtp.port", "465");
//	 
//	  Session session = Session.getDefaultInstance(props,
//	   new javax.mail.Authenticator() {
//	   protected PasswordAuthentication getPasswordAuthentication() {
//	   return new PasswordAuthentication("divyasundarsahu@gmail.com","password");//Put your email id and password here
//	   }
//	  });
//	 
//	//compose message
//	  try {
//	   MimeMessage message = new MimeMessage(session);
//	   message.setFrom(new InternetAddress("divyasundarsahu@gmail.com"));//change accordingly
//	   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//	   message.setSubject("Hello");
//	   message.setText("Testing.......");
//	   
//	   //send message
//	   Transport.send(message);
//
//	   System.out.println("message sent successfully");
//	 
//	  } catch (MessagingException e) {throw new RuntimeException(e);}
//	 
//	}
//
//}
