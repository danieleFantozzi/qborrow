package it.quix.academy.qborrow;

import javax.xml.ws.Endpoint;

import it.quix.academy.qborrow.web.ws.TestWsImpl;

public class PubTestWs {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/test", new TestWsImpl());

    }

}
