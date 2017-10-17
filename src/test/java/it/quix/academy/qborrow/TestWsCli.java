package it.quix.academy.qborrow;

import java.net.MalformedURLException;
import java.net.URL;

import it.quix.academy.qborrow.web.ws.TestWs;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestWsCli {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9999/ws/test?wsdl");
        QName qname = new QName("http://ws.web.qborrow.academy.quix.it/", "TestWsImplService");
        Service service = Service.create(url, qname);
        TestWs cli = service.getPort(TestWs.class);
        System.out.println(cli.getResponse("mkyong"));

    }

}
