package it.quix.academy.qborrow.core.dao;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.academy.qborrow.core.dao.generated.SoggettoAbstractDAO;

/**
 * The DAO for Soggetto entity.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT, generated 11/10/2017 15:25:56
 */
public class SoggettoDAO extends SoggettoAbstractDAO {

    private static Log log = LogFactory.getLog(SoggettoDAO.class);

    public SoggettoDAO(DataSource dataSource) {
        super(dataSource);
        if (log.isDebugEnabled()) {
            log.debug("SoggettoDAO initialized!");
        }
    }

}