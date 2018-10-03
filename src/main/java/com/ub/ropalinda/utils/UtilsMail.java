/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.utils;

import com.ub.ropalinda.entities.ProspectiveCustomer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author ulises
 */
public class UtilsMail {

    public static void sendMail(String hostName, int smtpPort, String userMail,
            String userPass, boolean ssl, String from, String subject,
            String msg, String toMail) {
        try {
            Email email = new SimpleEmail();
            email.setHostName(hostName);
            email.setSmtpPort(smtpPort);
            email.setAuthenticator(new DefaultAuthenticator(userMail, userPass));
            email.setSSL(ssl);
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(toMail);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(UtilsMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void sendMail(String hostMail, int port, String mail,
            String pass, String from, String subject, String msg, String toMail) {
        try {
            Email email = new SimpleEmail();
            email.setHostName(hostMail);
            email.setSmtpPort(port);
            email.setAuthenticator(new DefaultAuthenticator(mail, pass));
            email.setSSL(true);
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(msg);
            email.addTo(toMail);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(UtilsMail.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public static void sendActivationCode(String hostMail, int port, String mail,
            String pass, String from, String toMail, String codigoRecuperacion)
            throws EmailException, MalformedURLException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(hostMail);
        email.setSmtpPort(port);
        email.setAuthentication(mail, pass);
        email.setSSL(true);
        email.setFrom(mail);
        email.setSubject("Activación de cuenta");
        email.addTo(toMail);

        String htmlCadena
                = "<html>\n"
                + "   <body style=\"color: rgba(0,0,0, 0.8); font-family: verdana; font-size: 14px;\">\n"
                + "     <div style=\"width: 100%; display: flex; justfy-content: center;\">\n"
                + "       <div style=\"width: 70%;\">\n"
                + "         <div style=\"border: 1px solid rgba(128, 128, 128, 0.31); width: 100%; padding: 20px;\">\n"
                + "           <h3 style=\"margin-top: 0;\">\n"
                + "             Hola\n"
                + "           </h3>\n"
                + "           <p>Utilize el siguiente código para continuar con el proceso de recuperación de activación</p>\n"
                + "         <div style=\"background: #009BD2; color: white; padding: 10px; width: 100px; text-align: center;\">\n"
                + codigoRecuperacion
                + "         </div>\n"
                + "         </div>\n"
                + "         <div style=\"width: 100%; margin-bottom: 10px;\">\n"
                + "           <p style=\"margin-left: 20px; color: rgba(128, 128, 128, 0.5);\">\n"
                + "             Ropalinda, siempre a la moda.\n"
                + "           </p>\n"
                + "         </div>\n"
                + "       </div>\n"
                + "     </div>\n"
                + "   </body>\n"
                + "</html>";

        // set the html message           
        email.setHtmlMsg(htmlCadena);
        String defaultMsg = "Su código de recuperación es: " + codigoRecuperacion;
        // set the alternative message
        email.setTextMsg(defaultMsg);
        // send the email
        email.send();
    }

    public static void main(String[] args) {
        try {
            sendActivationCode("smtp.googlemail.com", 465, "ubg700@gmail.com",
                    ".toString(24);", "ubg700@gmail.com",
                    "beltrangomezulises@gmail.com", "456123");
        } catch (EmailException ex) {
            Logger.getLogger(UtilsMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(UtilsMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void testSendMail() {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(
                    "ubg700@gmail.com", ".toString(24);"));
            email.setSSL(true);
            email.setFrom("ubg700@gmail.com");
            email.setSubject("TestMail");
            email.setMsg("This is a test mail ... :-)");
            email.addTo("beltrangomezulises@gmail.com");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(UtilsMail.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    public static void testSendHTMLMail() {
        try {
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthentication("correo@gmail.com", "pass");
            email.setSSL(true);
            email.setFrom("test@gmail.com", "persona del correo");
            email.setSubject("Test email with inline image");
            email.addTo("test@gmail.com", "test");
            // embed the image and get the content id
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = email.embed(url, "Apache logo");
            // set the html message
            email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");
            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");
            // send the email
            email.send();
        } catch (EmailException | MalformedURLException ex) {
            Logger.getLogger(UtilsMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class ModelSendActivationCode {

        private ProspectiveCustomer pros;
        private String code;

        public ModelSendActivationCode() {
        }

        public ModelSendActivationCode(ProspectiveCustomer pros, String code) {
            this.pros = pros;
            this.code = code;
        }

        public ProspectiveCustomer getPros() {
            return pros;
        }

        public void setPros(ProspectiveCustomer pros) {
            this.pros = pros;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

    }

}
