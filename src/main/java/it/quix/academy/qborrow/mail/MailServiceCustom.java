package it.quix.academy.qborrow.mail;

import it.quix.academy.qborrow.core.dao.SoggettoDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailServiceCustom {

    private static Log log = LogFactory.getLog(MailServiceCustom.class);

    private String soggetto;

    private String destinatario;

    private String messaggio;

    private String mittente;

    private MailSender mailSender;

    /**
     * @return the soggetto
     */
    public String getSoggetto() {
        return soggetto;
    }

    /**
     * @param soggetto the soggetto to set
     */
    public void setSoggetto(String soggetto) {
        this.soggetto = soggetto;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @return the messaggio
     */
    public String getMessaggio() {
        return messaggio;
    }

    /**
     * @param messaggio the messaggio to set
     */
    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    /**
     * @return the mittente
     */
    public String getMittente() {
        return mittente;
    }

    /**
     * @param mittente the mittente to set
     */
    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public void init() {

        log.info("Mail Service Custom started");
    }

    public void sendEmail(String soggetto, String destinatario, String messaggio) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(soggetto);
            simpleMailMessage.setText(messaggio);
            simpleMailMessage.setFrom(mittente);
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("ERRORE INVIO EMAIL", e);
        }
    }

    /**
     * @return the mailSender
     */
    public MailSender getMailSender() {
        return mailSender;
    }

    /**
     * @param mailSender the mailSender to set
     */
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

}
