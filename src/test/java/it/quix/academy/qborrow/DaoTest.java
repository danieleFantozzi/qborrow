package it.quix.academy.qborrow;

import it.quix.academy.qborrow.core.dao.SoggettoDAO;
import it.quix.academy.qborrow.core.model.QborrowUserContext;
import it.quix.academy.qborrow.core.model.Soggetto;
import it.quix.academy.qborrow.core.search.SoggettoSearch;
import it.quix.academy.qborrow.mail.MailServiceCustom;
import it.quix.framework.core.exception.DAOCreateException;
import it.quix.framework.core.exception.DAOStoreException;
import it.quix.framework.core.manager.ManagerHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

    private static Log log = LogFactory.getLog(MailTest.class);

    protected static ApplicationContext applicationContext;

    @BeforeClass
    public static void setUpClass() throws Exception {

        try {
            String[] contextFileNames = { "qborrow-test-spring.xml" };
            log.debug("loading application contexts=" + Arrays.toString(contextFileNames));
            applicationContext = new ClassPathXmlApplicationContext(contextFileNames);

            QborrowUserContext uc = new QborrowUserContext();
            it.quix.framework.core.manager.UserContextHolder.setUserContext(uc);

            ManagerHolder.setManagerOnThreadLocal("qborrowManager", applicationContext.getBean("qborrowManager"));

        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            Assert.assertNull(ex);
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        applicationContext = null;
    }

    @Test
    public void creazioneNuovoSoggetto() {
        Soggetto soggetto = new Soggetto();
        SoggettoDAO soggettoDao = applicationContext.getBean(SoggettoDAO.class);
        soggetto.setUsername("danieleTest");
        soggetto.setNome("daniele67");
        soggetto.setCognome("Fantozzi");
        soggetto.setEmail("prova1@gmail.com");
        soggetto.setRagioneSociale("prova");
        soggetto.setImmagine("percorso1");
        soggetto.setDataUltimaModifica(new Date());
        try {
            soggettoDao.create(soggetto);
        } catch (DAOCreateException e) {
            log.error("errore inserimento soggetto", e);
        }

    }

    @Test
    public void listaSoggetti() {
        SoggettoDAO soggettoDao = applicationContext.getBean(SoggettoDAO.class);
        SoggettoSearch soggettoSearch = new SoggettoSearch();
        List<Soggetto> listSoggetti = new ArrayList<Soggetto>();
        listSoggetti = soggettoDao.getList(soggettoSearch);
        for (Soggetto soggetto : listSoggetti) {
            log.info(soggetto.toString());

        }
    }

    @Test
    public void updateSoggetto() {
        SoggettoDAO soggettoDao = applicationContext.getBean(SoggettoDAO.class);
        SoggettoSearch soggettoSearch = new SoggettoSearch();
        soggettoSearch.setUsername("utente1");
        List<Soggetto> listSoggetti = soggettoDao.getList(soggettoSearch);

        Soggetto soggettoRic = new Soggetto();
        log.info("dimensione lista=" + listSoggetti.size());
        if (listSoggetti != null && listSoggetti.size() > 0) {
            soggettoRic = listSoggetti.get(0);
            soggettoRic.setEmail("fakenuovo@gmail.com");
        }
        try {
            soggettoDao.update(soggettoRic);
        } catch (DAOStoreException e) {
            log.error("errore update soggetto", e);
        }

    }
}
