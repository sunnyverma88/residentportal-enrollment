package org.residentportal.portal.utility;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSender{
        
        static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	public static void sendEmail(String recipientAddress,String subject,String message) throws Exception {
		// takes input from e-mail form
		
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
                
                // Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		
		generateMailMessage = new MimeMessage(getMailSession);
                
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
		generateMailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress("shwetabh.gaurav@gmail.com"));
		generateMailMessage.setSubject(subject);
		generateMailMessage.setContent(message, "text/html");
                Address address = new InternetAddress("techieonthenetAdmin@techieonthenet.com","Techieonthenet-Admin");
                generateMailMessage.setFrom(address);
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
                try
                {
                transport.connect("smtp.sendgrid.net", "apikey", "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");
                transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
                transport.close();
            }
		catch(MessagingException e)
		{
			System.out.println(e);
		}
		
		// forwards to the view named "Result"
		
	}
	
	public static void main(String args[]) throws Exception
	{
		sendEmail("shwetabh.gaurav@gmail.com","test email","This is a test email");
		
	}
}
