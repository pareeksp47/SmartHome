package com.exchange.isep.helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;

public class JavaEmail {

  Properties emailProperties;
  Session mailSession;
  MimeMessage emailMessage;

  // SMTP configuration
  
  @Value("${smtp.port}")
  private String port;

  @Value("${smtp.host}")
  private String host;

  @Value("${smtp.user}")
  private String smtpUser;

  @Value("${smtp.password}")
  private String smtpPassword;

  public void setMailServerProperties() {
    emailProperties = System.getProperties();
    emailProperties.put("mail.smtp.port", port);
    emailProperties.put("mail.smtp.auth", "true");
    emailProperties.put("mail.smtp.starttls.enable", "true");
  }

  /**
   * Create email message
   * @param emailSubject
   * @param emailBody
   * @param userEmail
   * @throws AddressException
   * @throws MessagingException
   */
  public void createEmailMessage(String emailSubject, String emailBody, String userEmail)
  throws AddressException, MessagingException {
    mailSession = Session.getDefaultInstance(emailProperties, null);
    emailMessage = new MimeMessage(mailSession);
    emailMessage.addRecipient(Message.RecipientType.TO,
      new InternetAddress(userEmail));

      emailMessage.setSubject(emailSubject); emailMessage.setContent(emailBody, "text/html"); // for a html email

    }

   /**
    * Send email to the customer
    * @throws AddressException
    * @throws MessagingException
    */
    public void sendEmail() throws AddressException, MessagingException {
      
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(host, smtpUser, smtpPassword);
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();

    }
  }