package it.quix.academy.qborrow.core.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import flexjson.JSON;
import it.quix.academy.qborrow.Configuration;
import it.quix.academy.qborrow.core.manager.QborrowManager;
import it.quix.framework.core.composer.annotation.QrExcelColumn;
import it.quix.framework.core.converter.annotation.QcDateType;
import it.quix.framework.core.exception.DAOFinderException;
import it.quix.framework.core.exception.ModelJdbcException;
import it.quix.framework.core.handler.SysAttributeHandler;
import it.quix.framework.core.manager.UserContextHolder;
import it.quix.framework.core.model.AttributeView;
import it.quix.framework.core.model.UserContext;

/**
 * The Prestito entity.
 * 
 * @author Quix CodeGenerator version 03.03.00-SNAPSHOT, generated 11/10/2017 15:25:55
 */
@Entity
@Table(name = "prestiti")
public class Prestito extends QborrowAbstractModel implements Serializable {

    /**
     * The serialVersionUID is a universal version identifier for a Serializable class. Deserialization uses
     * this number to ensure that a loaded class corresponds exactly to a serialized object.
     * If no match is found, then an InvalidClassException is thrown.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Logger object
     */
    private static Log log = LogFactory.getLog(Prestito.class);

    /**
     * beneficiario <br>
     * username utente che ha l'oggetto prestato <br>
     * Property of field:
     * <ul>
     * <li>columnName = beneficiario
     * <li>nullable = true
     * </ul>
     * This field is part of the primary key of this entity.
     */
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beneficiario")
    @QrExcelColumn(order = 0, translate = true)
    private Soggetto beneficiario;

    @Transient
    private boolean beneficiarioJdbcAlreadyChecked = false;

    @Transient
    private String beneficiario_username;

    /**
     * oggetto_prestato <br>
     * id oggetto prestato <br>
     * Property of field:
     * <ul>
     * <li>columnName = oggetto_prestato
     * <li>nullable = true
     * </ul>
     * This field is part of the primary key of this entity.
     */
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oggetto_prestato")
    @QrExcelColumn(order = 0, translate = true)
    private Oggetto oggettoPrestato;

    @Transient
    private boolean oggettoPrestatoJdbcAlreadyChecked = false;

    @Transient
    private Integer oggettoPrestato_id;

    /**
     * Property of field:
     * <ul>
     * <li>length = 255
     * <li>columnName = data_scadenza
     * <li>nullable = false
     * </ul>
     */
    @Column(name = "data_scadenza", nullable = false)
    @QcDateType()
    @Temporal(TemporalType.DATE)
    @QrExcelColumn(order = 0)
    private Date dataScadenza;

    /**
     * Property of field:
     * <ul>
     * <li>length = 255
     * <li>columnName = data_prestito
     * <li>nullable = false
     * </ul>
     */
    @Column(name = "data_prestito", nullable = false)
    @QcDateType()
    @Temporal(TemporalType.DATE)
    @QrExcelColumn(order = 0)
    private Date dataPrestito;

    /**
     * Indicates whether some other object is "equal to" this one.
     * The equals method implements an equivalence relation on non-null object references:
     * <ul>
     * <li>It is reflexive: for any non-null reference value x, x.equals(x) should return true.</li>
     * <li>It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.</li>
     * <li>It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should
     * return true.</li>
     * <li>It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return
     * false, provided no information used in equals comparisons on the objects is modified.</li>
     * <li>For any non-null reference value x, x.equals(null) should return false.</li>
     * </ul>
     * The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for
     * any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).
     * Note that it is generally necessary to override the hashCode method whenever this method is overridden, so as to maintain the general contract
     * for the hashCode method, which states that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return rue if this object is the same as the obj argument; false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Prestito other = (Prestito) obj;
        if (beneficiario == null) {
            if (other.getBeneficiario() != null) {
                return false;
            }
        } else if (!beneficiario.equals(other.getBeneficiario())) {
            return false;
        }
        if (oggettoPrestato == null) {
            if (other.getOggettoPrestato() != null) {
                return false;
            }
        } else if (!oggettoPrestato.equals(other.getOggettoPrestato())) {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hashtables such as those provided by java.util.Hashtable.
     * The general contract of hashCode is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the
     * same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of
     * an application to another execution of the same application.</li>
     * <li>If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same
     * integer result.</li>
     * <li>It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the
     * two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects
     * may improve the performance of hashtables.</li>
     * </ul>
     * 
     * @return a hash code value for this object
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((beneficiario == null) ? 0 : beneficiario.hashCode());
        result = prime * result + ((oggettoPrestato == null) ? 0 : oggettoPrestato.hashCode());
        return result;
    }

    /**
     * Returns a string representation of the object. In general, the toString method returns a string that
     * "textually represents" this object. The result should be a concise but informative representation
     * that is easy for a person to read.
     * 
     * @return a string representation of the object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append("(");

        sb.append(", ").append("beneficiario=").append(beneficiario);

        sb.append(", ").append("oggettoPrestato=").append(oggettoPrestato);

        sb.append(", ").append("dataScadenza=").append(dataScadenza);

        sb.append(", ").append("dataPrestito=").append(dataPrestito);

        sb.append(")");
        return sb.toString();
    }

    /**
     * Executed before the persist operation is executed.
     * This method can raise a RuntimeException. The current transaction, if any, must be rolled back.
     */
    @PrePersist
    public void prePersist() {
    }

    /**
     * Executed before the persist operation is executed.
     * This method can raise a RuntimeException. The current transaction, if any, must be rolled back.
     */
    public void prePersist(Configuration configuration) {
        prePersist();
    }

    /**
     * Executed before the update operation is executed.
     * This method can raise a RuntimeException. The current transaction, if any, must be rolled back.
     */
    @PreUpdate
    public void preUpdate() {

    }

    /**
     * Executed before the update operation is executed.
     * This method can raise a RuntimeException. The current transaction, if any, must be rolled back.
     */
    public void preUpdate(Configuration configuration) {
        preUpdate();
    }

    /**
     * Executed before the delete operation is executed.
     * This method can raise a RuntimeException. The current transaction, if any, must be rolled back.
     */
    @PreRemove
    public void preRemove() {

    }

    /**
     * Executed before the delete operation is executed.
     * This method can raise a RuntimeException. The current transaction, if any, must be rolled back.
     */
    public void preRemove(Configuration configuration) {
        preRemove();

    }

    /**
     * Return the beneficiario
     * username utente che ha l'oggetto prestato <br>
     * Property of field:
     * <ul>
     * <li>columnName = beneficiario
     * <li>nullable = true
     * </ul>
     * 
     * @return the beneficiario
     * @see Prestito.beneficiario
     */

    public Soggetto getBeneficiario() {
        if (jdbc && beneficiario == null && beneficiario_username != null && !beneficiarioJdbcAlreadyChecked) {
            try {
                beneficiario = getQborrowManager().getSoggetto(beneficiario_username);
                beneficiarioJdbcAlreadyChecked = true;
            } catch (DAOFinderException e) {
                log.debug("Unexpected DAOFinderException on getBeneficiario by beneficiario_username = " + beneficiario_username, e);
            }
        }
        return beneficiario;
    }

    /**
     * Set the beneficiario
     * username utente che ha l'oggetto prestato <br>
     * Property of field:
     * <ul>
     * <li>columnName = beneficiario
     * <li>nullable = true
     * </ul>
     * 
     * @param beneficiario the beneficiario to set
     * @see Prestito.beneficiario
     */
    public void setBeneficiario(Soggetto beneficiario) {
        this.beneficiario = beneficiario;
        if (beneficiario != null) {
            beneficiario_username = beneficiario.getUsername();

        } else {
            beneficiario_username = null;
        }
    }

    public String getBeneficiario_username() {
        if (jdbc) {
            return beneficiario_username;
        } else {
            return beneficiario == null ? null : beneficiario.getUsername();
        }
    }

    public void setBeneficiario_username(String beneficiario_username) {
        if (jdbc) {
            if (this.beneficiario_username != null && !this.beneficiario_username.equals(beneficiario_username)) {
                beneficiario = null;
                beneficiarioJdbcAlreadyChecked = false;
            }
            this.beneficiario_username = beneficiario_username;
        } else {
            throw new ModelJdbcException("The method setBeneficiario_username can be invoked only on jdbc model.");
        }
    }

    /**
     * @return the beneficiarioJdbcAlreadyChecked
     * @see Prestito#beneficiarioJdbcAlreadyChecked
     */
    @JSON(include = false)
    public boolean isBeneficiarioJdbcAlreadyChecked() {
        return beneficiarioJdbcAlreadyChecked;
    }

    /**
     * @param beneficiarioJdbcAlreadyChecked the beneficiarioJdbcAlreadyChecked to set
     * @see Prestito#beneficiarioJdbcAlreadyChecked
     */
    public void setBeneficiarioJdbcAlreadyChecked(boolean beneficiarioJdbcAlreadyChecked) {
        this.beneficiarioJdbcAlreadyChecked = beneficiarioJdbcAlreadyChecked;
    }

    /**
     * Return the oggetto_prestato
     * id oggetto prestato <br>
     * Property of field:
     * <ul>
     * <li>columnName = oggetto_prestato
     * <li>nullable = true
     * </ul>
     * 
     * @return the oggettoPrestato
     * @see Prestito.oggettoPrestato
     */

    public Oggetto getOggettoPrestato() {
        if (jdbc && oggettoPrestato == null && oggettoPrestato_id != null && !oggettoPrestatoJdbcAlreadyChecked) {
            try {
                oggettoPrestato = getQborrowManager().getOggetto(oggettoPrestato_id);
                oggettoPrestatoJdbcAlreadyChecked = true;
            } catch (DAOFinderException e) {
                log.debug("Unexpected DAOFinderException on getOggettoPrestato by oggettoPrestato_id = " + oggettoPrestato_id, e);
            }
        }
        return oggettoPrestato;
    }

    /**
     * Set the oggetto_prestato
     * id oggetto prestato <br>
     * Property of field:
     * <ul>
     * <li>columnName = oggetto_prestato
     * <li>nullable = true
     * </ul>
     * 
     * @param oggettoPrestato the oggetto_prestato to set
     * @see Prestito.oggettoPrestato
     */
    public void setOggettoPrestato(Oggetto oggettoPrestato) {
        this.oggettoPrestato = oggettoPrestato;
        if (oggettoPrestato != null) {
            oggettoPrestato_id = oggettoPrestato.getId();

        } else {
            oggettoPrestato_id = null;
        }
    }

    public Integer getOggettoPrestato_id() {
        if (jdbc) {
            return oggettoPrestato_id;
        } else {
            return oggettoPrestato == null ? null : oggettoPrestato.getId();
        }
    }

    public void setOggettoPrestato_id(Integer oggettoPrestato_id) {
        if (jdbc) {
            if (this.oggettoPrestato_id != null && !this.oggettoPrestato_id.equals(oggettoPrestato_id)) {
                oggettoPrestato = null;
                oggettoPrestatoJdbcAlreadyChecked = false;
            }
            this.oggettoPrestato_id = oggettoPrestato_id;
        } else {
            throw new ModelJdbcException("The method setOggettoPrestato_id can be invoked only on jdbc model.");
        }
    }

    /**
     * @return the oggettoPrestatoJdbcAlreadyChecked
     * @see Prestito#oggettoPrestatoJdbcAlreadyChecked
     */
    @JSON(include = false)
    public boolean isOggettoPrestatoJdbcAlreadyChecked() {
        return oggettoPrestatoJdbcAlreadyChecked;
    }

    /**
     * @param oggettoPrestatoJdbcAlreadyChecked the oggettoPrestatoJdbcAlreadyChecked to set
     * @see Prestito#oggettoPrestatoJdbcAlreadyChecked
     */
    public void setOggettoPrestatoJdbcAlreadyChecked(boolean oggettoPrestatoJdbcAlreadyChecked) {
        this.oggettoPrestatoJdbcAlreadyChecked = oggettoPrestatoJdbcAlreadyChecked;
    }

    /**
     * <br>
     * Property of field:
     * <ul>
     * <li>length = 255
     * <li>columnName = data_scadenza
     * <li>nullable = false
     * </ul>
     * 
     * @return the dataScadenza
     * @see Prestito.dataScadenza
     */

    public Date getDataScadenza() {
        return dataScadenza;
    }

    /**
     * <br>
     * Property of field:
     * <ul>
     * <li>length = 255
     * <li>columnName = data_scadenza
     * <li>nullable = false
     * </ul>
     * 
     * @param dataScadenza
     * @see Prestito.dataScadenza
     */
    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    /**
     * <br>
     * Property of field:
     * <ul>
     * <li>length = 255
     * <li>columnName = data_prestito
     * <li>nullable = false
     * </ul>
     * 
     * @return the dataPrestito
     * @see Prestito.dataPrestito
     */

    public Date getDataPrestito() {
        return dataPrestito;
    }

    /**
     * <br>
     * Property of field:
     * <ul>
     * <li>length = 255
     * <li>columnName = data_prestito
     * <li>nullable = false
     * </ul>
     * 
     * @param dataPrestito
     * @see Prestito.dataPrestito
     */
    public void setDataPrestito(Date dataPrestito) {
        this.dataPrestito = dataPrestito;
    }

}