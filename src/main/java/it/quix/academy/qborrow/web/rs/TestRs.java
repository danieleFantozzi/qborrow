package it.quix.academy.qborrow.web.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.quix.academy.qborrow.core.dao.OggettoDAO;
import it.quix.academy.qborrow.core.dao.SoggettoDAO;
import it.quix.academy.qborrow.core.manager.QborrowManager;
import it.quix.academy.qborrow.core.model.Oggetto;
import it.quix.academy.qborrow.core.search.OggettoSearch;
import it.quix.academy.qborrow.core.search.SoggettoSearch;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/oggetti")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestRs {

    @Resource(name = "qborrowManager")
    protected QborrowManager qborrowmanager;

    @GET
    public Response getOggetti() {

        List<Oggetto> listOggetti = new ArrayList<Oggetto>();
        OggettoSearch oggettoSearch = new OggettoSearch();
        listOggetti = qborrowmanager.getOggettoList(oggettoSearch);
        // oggetto.setCategoria("penna");
        return Response.ok(listOggetti, MediaType.APPLICATION_JSON).build();

    }

    @POST
    public Oggetto postOggetto(Oggetto oggetto) {
        return oggetto;
    }

    @PUT
    public Oggetto putOggetto(Oggetto oggetto) {
        Oggetto oggetto2 = new Oggetto();

        return oggetto;
    }

    @DELETE
    public String deleteOggetto(Oggetto oggetto) {
        Oggetto oggetto2 = new Oggetto();

        return "ciao";
    }

}
