package com.sample.model;



import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Sender{

	public static void EmailSender() {

		final String username = "jstestmail1234567890@gmail.com";
		final String password = "Testmail123$$";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS

		Session session = Session.getInstance(prop,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jstestmail1234567890@gmail.com"));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse("james.halliday@engineering.digital.dwp.gov.uk, james.halliday@dwp.gsi.gov.uk, josef.doughty1@dwp.gsi.gov.uk, george.stanway1@dwp.gsi.gov.uk, nathan.welsh@dwp.gsi.gov.uk")
					//					
					);
			message.setSubject("Testing Gmail");



			Multipart multipart = new MimeMultipart();

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Dear all,"
					+ "\n\nSame as this time, except this time it works...  Hopefully \n\nJames");
			multipart.addBodyPart(messageBodyPart);
						
			messageBodyPart = new MimeBodyPart();
	         String filename = "OnCall.xlsx";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);

			Transport.send(message);

			System.out.println("Done");

		} 



		catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("\n\n\nERROR SENDER\n\n\n");
		}
	}

}
