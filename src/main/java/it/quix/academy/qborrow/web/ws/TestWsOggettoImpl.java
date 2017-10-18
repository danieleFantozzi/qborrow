package it.quix.academy.qborrow.web.ws;

import java.util.Date;

import javax.jws.WebService;

import it.quix.academy.qborrow.core.model.Oggetto;

@WebService(endpointInterface = "it.quix.academy.qborrow.web.ws.TestWsOggetto")
public class TestWsOggettoImpl implements TestWsOggetto {

    public Oggetto getObject(Integer id) {
        Oggetto oggetto = new Oggetto();
        oggetto.setId(100);
        oggetto.setDataUltimaModifica(new Date());
        oggetto.setDescrizione("descrizione1");
        return oggetto;
    }
}
