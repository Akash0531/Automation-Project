package com.dikshatech.tst.utilitylibrary;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.mail.*;
import org.testng.annotations.Test;

public class MailGenerator {

	@Test
	public static void emailSender() throws MalformedURLException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Sending mail via script");
		attachment.setName("Akash Anand");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("akashanand0531@gmail.com", "jssate@2011"));
		email.setSSLOnConnect(true);
		try {
			email.addTo("akashdtemper@gmail.com", "Akash Anand");
			email.setFrom("akashanand0531@gmail.com", "Akash");
			email.setSubject("The picture");
			email.setMsg("Here is the picture attached in the mail through script");

			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
			System.out.println("Yipee..!! Mail sent successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			email.setBounceAddress("");
			e.printStackTrace();
			
		}
	}
}
