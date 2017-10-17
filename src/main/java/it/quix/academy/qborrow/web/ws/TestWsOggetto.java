package it.quix.academy.qborrow.web.ws;

import it.quix.academy.qborrow.core.model.Oggetto;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TestWsOggetto {
	
	@WebMethod
    Oggetto getObject(Integer id);
}
