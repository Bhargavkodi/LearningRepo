package com.beginningdeveloper.maven.NewProject;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class sendEmail {

	private static final String HOST = "smtp.gmail.com";
	private static final int PORT = 465;
	private static final boolean SSL_FLAG = true;

	public static void main(String[] args) {
		sendEmail.sendSimpleEmail("mroads.vnr@gmail.com");
	}

	static void sendSimpleEmail(String receiver) {

		String userName = "mroads.vnr@gmail.com";
		String password = "gaurav14";

		String fromAddress = "mroads.vnr@gmail.com";
		String subject = "Interview scheduled for the position of DTCP-02 for Panna inc.";
		String message = "Successfully scheduled interview(s)" + '\n' + '\n' + '\n'
				+ "This is an auto generated eamil after successful schedule from script";

		try {
			Email email = new SimpleEmail();
			email.setHostName(HOST);
			email.setSmtpPort(PORT);
			email.setAuthenticator(new DefaultAuthenticator(userName, password));
			email.setSSLOnConnect(SSL_FLAG);
			email.setFrom(fromAddress);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(receiver);
			email.send();
			System.out.println("send email");
		} catch (Exception ex) {
			System.out.println("Unable to send email");
			System.out.println(ex);
		}
	}

}
