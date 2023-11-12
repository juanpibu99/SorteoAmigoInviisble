package sdf;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	   // Configuración de propiedades del servidor SMTP de Gmail
    
    
    public void sendEmail(Participante destinatario) {
    	String codigoHTML = "<!DOCTYPE html>\n" +
    	        "<html lang=\"es\">\n" +
    	        "<head>\n" +
    	        "    <meta charset=\"UTF-8\">\n" +
    	        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
    	        "    <title>Sorteo Amigo Invisible</title>\n" +
    	        "</head>\n" +
    	        "<body style=\"font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #fff8f0; margin: 0; padding: 0;\">\n" +
    	        "    <div style=\"max-width: 600px; margin: 20px auto; background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);\">\n" +
    	        "        <h1 style=\"color: #d9534f; text-align: center;\">¡Sorteo de Amigo Invisible!</h1>\n" +
    	        "        <p style=\"color: #333333; line-height: 1.6; text-align: center;\">Estimado participante,</p>\n" +
    	        "        <p style=\"color: #333333; line-height: 1.6; text-align: center;\">¡Es esa maravillosa época del año nuevamente! Hemos organizado el Sorteo de Amigo Invisible y estás participando. Abre tu regalo con alegría y descubre quién te ha tocado.</p>\n" +
    	        "        <p style=\"color: #333333; line-height: 1.6; text-align: center;\"><strong>Tu amigo invisible es:</strong></p>\n" +
    	        "        <p style=\"color: #333333; padding-left: 20px; text-align: center;\">"+ destinatario.getParticipanteTocado().getNombre() +" "+destinatario.getParticipanteTocado().getApellidos() +"</p>" +
    	        "        <p style=\"color: #333333; line-height: 1.6; text-align: center;\">¡Que tengas unas felices fiestas!</p>\n" +
    	        "        <img src=\"https://i.pinimg.com/originals/31/e5/bf/31e5bf54cf7f718a999916db2e74f365.gif\" alt=\"Christmas\" style=\"width: 100%; border-radius: 10px;\">\n" +

    	        "        <div style=\"margin-top: 20px; text-align: center; color: #999999;\">\n" +
    	        "            <p>© 2023 Amigo Invisible</p>\n" +
    	        "        </div>\n" +
    	        "    </div>\n" +
    	        "</body>\n" +
    	        "</html>";



    	
    	 Properties properties = new Properties();
    	 properties.put("mail.smtp.host", "smtp.gmail.com");
    	 properties.put("mail.smtp.port", "587");
    	 properties.put("mail.smtp.auth", "true");
    	 properties.put("mail.smtp.starttls.enable", "true");
    	 
    	// Credenciales de tu cuenta de Gmail
    	    String username = "navidadsorteo7@gmail.com";
    	    String password = "ehya xaxy tula qcmy";

    	    // Crear sesión con autenticación
    	    Session session = Session.getInstance(properties, new Authenticator() {
    	        protected PasswordAuthentication getPasswordAuthentication() {
    	            return new PasswordAuthentication(username, password);
    	        }
    	    });

    	    try {
    	        // Crear mensaje de correo
    	        Message message = new MimeMessage(session);
    	        message.setFrom(new InternetAddress("navidadsorteo7@gmail.com"));
    	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario.getCorreo()));
    	        message.setSubject(destinatario.getNombre()+" ya tienes amigo invisible");
    	        message.setContent(codigoHTML, "text/html");

    	        // Enviar el mensaje
    	        Transport.send(message);

    	        System.out.println("¡Correo enviado con éxito!");

    	    } catch (MessagingException e) {
    	        e.printStackTrace();
    	        System.out.println("Error al enviar el correo: " + e.getMessage());
    	    }
    	}

    }
   
    
