package it.quix.academy.qborrow;

import javax.xml.ws.Endpoint;

import it.quix.academy.qborrow.web.ws.TestWsImpl;
import it.quix.academy.qborrow.web.ws.TestWsOggettoImpl;

public class PubTestWsOggetto {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9998/ws/test2", new TestWsOggettoImpl());

    }

}
