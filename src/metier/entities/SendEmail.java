package metier.entities;

import java.util.*;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {

public void envoyerEmail(String to,String subject,String messageTxt) {
	 // Recipient's email ID needs to be mentioned.
    //String to = "oussamazaghdoud1991@gmail.com";

    // Sender's email ID needs to be mentioned
   String from = "Cfbm.Training@gmail.com";
    String password="centre2020";

    // Assuming you are sending email from localhost
    String host = "smtp.gmail.com";

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.setProperty("mail.smtp.host", host);
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");
    properties.setProperty("mail.smtp.port", "587");


    // Get the default Session object.
    Session session = Session.getDefaultInstance(properties,new Authenticator() {
  	  
  	  @Override
  	protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(from, password);    
}
  	
	});
    

    try {
       // Create a default MimeMessage object.
       MimeMessage message = new MimeMessage(session);

       // Set From: header field of the header.
       message.setFrom(new InternetAddress(from));

       // Set To: header field of the header.
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

       // Set Subject: header field
       message.setSubject(subject);

       // Now set the actual message
       message.setText(messageTxt);

       // Send message
       Transport.send(message);
    } catch (MessagingException mex) {
       mex.printStackTrace();
    }
 }
}