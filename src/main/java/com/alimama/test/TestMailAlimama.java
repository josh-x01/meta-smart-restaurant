package com.alimama.test;

import com.alimama.mail.MailAlimama;

public class TestMailAlimama {
	public static void main(String[] args) {
		new MailAlimama().sendToAlimama("hello alimama", "eyasuyid@gmail.com");
	}
}
