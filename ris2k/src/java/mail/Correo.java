package mail;

import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import model.Jugador;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Correo{
    static Logger log = Logger.getLogger(Correo.class);    
    public Correo(){        
    }
    
    public static boolean enviarCorreo(Jugador jugador){
        try {
            String user=jugador.getUser();
            String password=jugador.getPassword();
            String email=jugador.getEmail();
            Properties props = new Properties();
            //props.put(127.0.0.1, "localhost");
            props.put("127.0.0.1","localhost");
            Session session = Session.getDefaultInstance(props, null);
            Message msg = new MimeMessage(session);
            InternetAddress desde = new InternetAddress("ris2k@ris2k.com");
            msg.setFrom(desde);
            InternetAddress destino = new InternetAddress(email);
            msg.addRecipient(Message.RecipientType.TO, destino);
            msg.setSubject("REGISTRO RIS2K");
            msg.setText("Se registro correctamente al usuario: "+user+"."+"\nSu contraseña es: "+password+"."+"\n\nBienvenido al juego " +
                    "RIS2K.");
            Transport.send(msg);
            System.out.println("SE ENVIO EL CORREO DE REGISTRO.");
            return true;
        } catch (AddressException ex) {
            log.warn("Se produjo un error con la dirección de correo al enviar el correo de registro");
            ex.printStackTrace();
            return false;
        } catch (MessagingException ex) {
            log.warn("No se pudo enviar el correo de registro");
            ex.printStackTrace();
            return false;
        }
    }
}