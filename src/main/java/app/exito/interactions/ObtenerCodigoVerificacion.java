package app.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import javax.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ObtenerCodigoVerificacion implements Interaction {

    public static String codigoVerificacion;

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "proyectofavoritappgrupo1@gmail.com", "bvhv wstb axmw umak");

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();

            StringBuilder messagesString = new StringBuilder();

            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];
                String subject = message.getSubject();
                messagesString.append("Subject: ").append(subject).append("\n");
                break;
            }
            String subject = messagesString.toString();
            codigoVerificacion = extraerCodigo(subject);
            inbox.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static String extraerCodigo(String subject) {
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(subject);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }

    public static ObtenerCodigoVerificacion on() {
        return new ObtenerCodigoVerificacion();
    }
}
