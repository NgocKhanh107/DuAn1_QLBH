/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author admin
 */
public class SenEmail {

    private String emailAddressTo = new String();
    private String msgText = new String();

    final String USER_NAME = "hoangntph19818@fpt.edu.vn";
    final String PASSSWORD = "hoangnowbee";
    final String FROM_ADDRESS = "hoangntph19818@fpt.edu.vn";
//    final String USER_NAME = "khanhdnph27550@fpt.edu.vn";
//    final String PASSSWORD = "khanh1007@";
//    final String FROM_ADDRESS = "khanhdnph27550@fpt.edu.vn";

    public void createAndSendEmail(String emailAddressTo, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_NAME, PASSSWORD);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER_NAME));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailAddressTo)
            );
            message.setSubject("Nhà hàng HAK xin chào !");
            message.setText(msgText);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
