
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class TLSEmailSender {

    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.yandex.ru");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.auth", "true");


        Session session = Session.getInstance(properties,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("JMGuti@yandex.ru","***");
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("JMGuti@yandex.ru"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("guti.haz14@,"));
            message.setSubject("Subject");

            MailReader mailReader = new MailReader();
            Map<String, String> accountMap = mailReader.readAccount();
            String lastName = null;
            String numMobile = null;
            for (Map.Entry entry : accountMap.entrySet()) {
                lastName = (String) entry.getKey();
                numMobile = (String) entry.getValue();
            }
            message.setText(lastName + " " + numMobile);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}






