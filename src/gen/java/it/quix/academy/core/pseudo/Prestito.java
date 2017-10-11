package it.quix.academy.core.pseudo;

import java.util.Date;

import it.quix.framework.core.codegen.annotation.OrderByTypeEnum;
import it.quix.framework.core.codegen.annotation.QgEditField;
import it.quix.framework.core.codegen.annotation.QgLabel;
import it.quix.framework.core.codegen.annotation.QgListColumnField;
import it.quix.framework.core.codegen.annotation.QgOrderBy;
import it.quix.framework.core.codegen.annotation.QgSearchField;
import it.quix.framework.core.codegen.annotation.QgSortable;
import it.quix.framework.core.codegen.annotation.SearchFieldType;
import it.quix.framework.core.converter.annotation.QcDateType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="prestiti")
public class Prestito {
	@Id
	@QgLabel(label = "beneficiario", description = "username utente che ha l'oggetto prestato")
	@ManyToOne(optional = false)
	@QgEditField(editFieldType=SearchFieldType.POPUP_SEARCH_FIELD)
	@QgListColumnField
	@JoinColumn(name = "beneficiario")
	public Soggetto beneficiario;
	
	@Id
	@QgLabel(label = "oggetto_prestato", description = "id oggetto prestato")
	@ManyToOne(optional = false)
	@QgListColumnField
	@JoinColumn(name = "oggetto_prestato")
	@QgEditField(editFieldType=SearchFieldType.POPUP_SEARCH_FIELD)
	public Oggetto oggettoPrestato;
	
	@Column(name="data_scadenza",nullable=false)
	@QcDateType
	@Temporal(TemporalType.DATE)
	@QgOrderBy(type=OrderByTypeEnum.DESC,position=0)
	@QgListColumnField
	@QgSortable
	@QgSearchField
	public Date dataScadenza;
	
	@Column(name="data_prestito", nullable=false)
	@QcDateType
	@QgOrderBy(type=OrderByTypeEnum.ASC,position=1)
	@QgSortable
	@Temporal(TemporalType.DATE) 
	@QgListColumnField
	@QgSearchField
	public Date dataPrestito;
	
	
}
