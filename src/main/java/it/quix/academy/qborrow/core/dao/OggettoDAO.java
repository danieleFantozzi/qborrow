package it.quix.academy.qborrow.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import it.quix.academy.qborrow.core.dao.generated.OggettoAbstractDAO;
import it.quix.academy.qborrow.core.model.Oggetto;
import it.quix.academy.qborrow.core.model.Prestito;
import it.quix.academy.qborrow.core.model.Soggetto;
import it.quix.academy.qborrow.core.search.OggettoSearch;
import it.quix.framework.util.FrameworkStringUtils;
import it.quix.framework.util.exceptions.SystemException;

/**
 * The DAO for Oggetto entity.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT, generated 11/10/2017 15:25:56
 */
public class OggettoDAO extends OggettoAbstractDAO {

    private static Log log = LogFactory.getLog(OggettoDAO.class);

    public OggettoDAO(DataSource dataSource) {
        super(dataSource);
        if (log.isDebugEnabled()) {
            log.debug("OggettoDAO initialized!");
        }
    }

    /**
     * lista dei miei oggetti in prestito
     * 
     * @param search
     * @return a list of oggetti
     */

    public List<Oggetto> getMieiOggettiList(OggettoSearch search) {
        List<Oggetto> list = new ArrayList<Oggetto>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Compose the select query
            StringBuilder query = new StringBuilder(EOL);
            query.append(" SELECT oggetti.*, prestiti.beneficiario ,prestiti.data_prestito, prestiti.data_scadenza , soggetti.nome, soggetti.cognome ").append(
                EOL);
            query.append(" FROM oggetti ").append(EOL);
            query.append(" LEFT JOIN prestiti on oggetti.id=prestiti.oggetto_prestato ");
            query.append(" LEFT JOIN soggetti on prestiti.beneficiario=soggetti.username ");
            query.append(" WHERE 1= 1 ").append(EOL);
            Map<Integer, Object> parameters = new HashMap<Integer, Object>();
            query.append(getWhereQuery(parameters, search));
            addOrderClause(search, query);

            // Query logging
            if (queryLog.isInfoEnabled()) {
                queryLog.info(query);
            }
            // Get connection
            connection = getConnection();
            // Prepare the statement
            statement = connection.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            // Set the parameters
            setParameters(statement, parameters);
            // Execute the query
            long startTime = System.currentTimeMillis();
            rs = statement.executeQuery();
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            String msgTime = FrameworkStringUtils.concat("Query time: ", time);
            if (queryLog.isDebugEnabled()) {
                queryLog.debug(msgTime);
            }
            int count = 0;
            skipFirstRows(rs, search);
            while (rs.next()) {
                Oggetto oggetto = new Oggetto();

                oggetto.setJdbc(true);
                oggetto.setQborrowManager(qborrowManager);

                oggetto.setProprietario_username(getParameterString(rs, "proprietario"));
                oggetto.setId(getParameterInteger(rs, "id"));
                oggetto.setTitolo(getParameterString(rs, "titolo"));
                oggetto.setDescrizione(getParameterString(rs, "descrizione"));
                oggetto.setCategoria(getParameterString(rs, "categoria"));
                oggetto.setImmagine(getParameterString(rs, "immagine"));
                oggetto.setDataUltimaModifica(getParameterDate(rs, "data_ultima_modifica"));

                if (getParameterString(rs, "beneficiario") != null) {
                    oggetto.setOggettoPrestato(true);
                    Prestito prestito = new Prestito();
                    prestito.setDataScadenza(getParameterDate(rs, "data_scadenza"));
                    prestito.setDataPrestito(getParameterDate(rs, "data_prestito"));

                    Soggetto soggetto = new Soggetto();
                    soggetto.setUsername(getParameterString(rs, "beneficiario"));
                    soggetto.setNome(getParameterString(rs, "nome"));
                    soggetto.setCognome(getParameterString(rs, "cognome"));
                    prestito.setBeneficiario(soggetto);
                    oggetto.setPrestito(prestito);
                }

                list.add(oggetto);
                count++;
                if (stopRows(count, search)) {
                    break;
                }
            }
            return list;
        } catch (SQLException ex) {
            String msg = "Unexpeted error on find Oggetto  on database.";
            if (log.isErrorEnabled()) {
                log.error(msg, ex);
            }
            throw new SystemException(msg, ex);
        } finally {
            closeResultSet(rs);
            closeStatement(statement);
            closeConnection(connection);
        }
    }

    /**
     * Return the StringBuilder that compose where clause on query
     * 
     * @param parameters
     * @param OggettoSearch the search model
     * @return the StringBuilder that compose where clause on query
     */
    protected StringBuilder getWhereQuery(Map<Integer, Object> parameters, OggettoSearch search) {
        StringBuilder whereClause = new StringBuilder("");
        int p = 1;
        if (search.getId() != null) {
            whereClause.append("AND id = ? ");
            parameters.put(new Integer(p), search.getId());
            p++;
        } else {

        }

        if (StringUtils.isNotEmpty(search.getTitolo())) {
            whereClause.append("AND titolo  LIKE ? ");
            parameters.put(new Integer(p), "%" + search.getTitolo() + "%");
            p++;
        }
        if (StringUtils.isNotEmpty(search.getDescrizione())) {
            whereClause.append("AND descrizione  LIKE ? ");
            parameters.put(new Integer(p), "%" + search.getDescrizione() + "%");
            p++;
        }
        if (StringUtils.isNotEmpty(search.getCategoria())) {
            whereClause.append("AND categoria  LIKE ? ");
            parameters.put(new Integer(p), "%" + search.getCategoria() + "%");
            p++;
        }
        if (StringUtils.isNotEmpty(search.getImmagine())) {
            whereClause.append("AND immagine  LIKE ? ");
            parameters.put(new Integer(p), "%" + search.getImmagine() + "%");
            p++;
        }
        if (search.getDataUltimaModificaFrom() != null) {
            whereClause.append("AND data_ultima_modifica >= ? ");
            parameters.put(new Integer(p), search.getDataUltimaModificaFrom());
            p++;
        }
        if (search.getDataUltimaModificaTo() != null) {
            whereClause.append("AND data_ultima_modifica <= ? ");
            parameters.put(new Integer(p), search.getDataUltimaModificaTo());
            p++;
        }
        if (search.getIsInPrestito() != null) {
            if (search.getIsInPrestito()) {
                whereClause.append("AND beneficiario is not null ");

            } else {
                whereClause.append("AND beneficiario is null ");

            }
        }

        if (search.getProprietario() != null) {
            whereClause.append("AND proprietario = ?  ");
            parameters.put(new Integer(p), search.getProprietario().getUsername());
            p++;
        } else {
            if (search.getProprietario_username() != null) {
                whereClause.append("AND proprietario = ? ");
                parameters.put(new Integer(p), search.getProprietario_username());
                p++;
            }

        }
        return whereClause;
    }

    public Long countMieiOggetti(OggettoSearch search) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Compose the select query
            StringBuilder query = new StringBuilder(EOL);
            query.append(" SELECT COUNT(*) AS TOT ").append(EOL);
            query.append(" FROM oggetti ").append(EOL);
            query.append(" LEFT JOIN prestiti on oggetti.id=prestiti.oggetto_prestato ");
            query.append(" LEFT JOIN soggetti on prestiti.beneficiario=soggetti.username ");
            query.append(" WHERE 1 = 1  ");

            Map<Integer, Object> parameters = new HashMap<Integer, Object>();
            query.append(getWhereQuery(parameters, search));
            // Query logging
            if (queryLog.isInfoEnabled()) {
                queryLog.info(query);
            }
            // Get connection
            connection = getConnection();
            // Prepare the statement
            statement = connection.prepareStatement(query.toString());
            // Set the parameters
            setParameters(statement, parameters);

            // Execute the query
            long startTime = System.currentTimeMillis();
            rs = statement.executeQuery();
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            String msgTime = FrameworkStringUtils.concat("Query time: ", time);
            if (queryLog.isDebugEnabled()) {
                queryLog.debug(msgTime);
            }
            long nRow = 0;
            if (rs.next()) {
                nRow = rs.getLong("TOT");
            }
            return nRow;
        } catch (Exception ex) {
            if (log.isErrorEnabled()) {
                log.error(ex.getMessage(), ex);
            }
            throw new SystemException(ex);
        } finally {
            closeResultSet(rs);
            closeStatement(statement);
            closeConnection(connection);
        }
    }

}