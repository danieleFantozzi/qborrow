package it.quix.academy.qborrow;

import java.net.MalformedURLException;
import java.net.URL;

import it.quix.academy.qborrow.web.ws.TestWsOggetto;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestWsOggettoCli {

    public static void main(String[] args) throws MalformedURLException {
        Integer id=50;
        
    	URL url = new URL("http://localhost:9998/ws/test2?wsdl");
        QName qname = new QName("http://ws.web.qborrow.academy.quix.it/", "TestWsOggettoImplService");
        Service service = Service.create(url, qname);
        TestWsOggetto cli = service.getPort(TestWsOggetto.class);
        System.out.println(cli.getObject(id));

    }

}
