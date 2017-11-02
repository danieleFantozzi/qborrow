package it.quix.academy.qborrow.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.academy.qborrow.core.dao.generated.PrestitoAbstractDAO;
import it.quix.academy.qborrow.core.model.Prestito;
import it.quix.framework.core.exception.DAOStoreException;
import it.quix.framework.util.FrameworkStringUtils;
import it.quix.framework.util.exceptions.SystemException;

/**
 * The DAO for Prestito entity.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT, generated 11/10/2017 15:25:56
 */
public class PrestitoDAO extends PrestitoAbstractDAO {

    private static Log log = LogFactory.getLog(PrestitoDAO.class);

    public PrestitoDAO(DataSource dataSource) {
        super(dataSource);
        if (log.isDebugEnabled()) {
            log.debug("PrestitoDAO initialized!");
        }
    }

    public void updatePrestitoOnlyPrestato(Prestito prestito) throws DAOStoreException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Compose the update query
            StringBuilder query = new StringBuilder(EOL);
            query.append(" UPDATE prestiti SET ").append(EOL);
            query.append(" beneficiario = ? , data_scadenza = ? , data_prestito = ?  ").append(EOL);
            query.append("  WHERE  oggetto_prestato = ? ").append(EOL);

            // Query logging
            if (queryLog.isInfoEnabled()) {
                queryLog.info(query);
            }
            // Get connection
            connection = getConnection();
            // Prepare the statement
            statement = connection.prepareStatement(query.toString());

            // set preUpdate
            prestito.preUpdate(configuration);

            // Set the parameters
            int p = 1;
            super.setParameterString(statement, p++, prestito.getBeneficiario_username());

            super.setParameterDate(statement, p++, prestito.getDataScadenza());
            super.setParameterDate(statement, p++, prestito.getDataPrestito());

            // Set the primary key
            super.setParameterInteger(statement, p++, prestito.getOggettoPrestato_id());

            // Execute the query
            long startTime = System.currentTimeMillis();
            int numberOfUpdatedRecord = statement.executeUpdate();
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            String msgTime = FrameworkStringUtils.concat("Query time: ", time);
            if (queryLog.isDebugEnabled()) {
                queryLog.debug(msgTime);
            }
            if (numberOfUpdatedRecord < 1) {
                String msg =
                    FrameworkStringUtils.concat("Error while updating the record of type Prestito ", prestito, " on database. Number of updated rows: ",
                        numberOfUpdatedRecord);
                if (log.isWarnEnabled()) {
                    log.warn(msg);
                }
                throw new DAOStoreException(msg);
            }
        } catch (SQLException ex) {
            String msg = FrameworkStringUtils.concat("Unexpeted error during update of record of type Prestito ", prestito, " on database.");
            if (log.isErrorEnabled()) {
                log.error(msg, ex);
            }
            throw new SystemException(msg, ex);
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }
    }

}