
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public  class Main {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.ssl.enable", "true");

//        new PasswordAuthentication
//                ("lazizbek.fayzullayev.17@gmail.com","tecgwlkvudezlcuh".toCharArray());

        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication
                        ("lazizbek.fayzullayev.17@gmail.com",
                                "lomcoiimqaawwnve");
            }
        };
        Session session = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("lazizbek.fayzullayev.17@gmail.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("tony.lazizbek.123456@gmail.com"));
        message.setSubject("Testing of sending mail");
        message.setText("Dear Developer, \n you just crashed our server with code. \n Please revert back all your trash code");
        Transport.send(message);
    }
}