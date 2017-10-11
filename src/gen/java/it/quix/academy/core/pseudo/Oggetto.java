package it.quix.academy.core.pseudo;

import java.util.Date;
import java.util.Set;

import it.quix.framework.core.codegen.annotation.OrderByTypeEnum;
import it.quix.framework.core.codegen.annotation.QgAttribute;
import it.quix.framework.core.codegen.annotation.QgEditField;
import it.quix.framework.core.codegen.annotation.QgLabel;
import it.quix.framework.core.codegen.annotation.QgListColumnField;
import it.quix.framework.core.codegen.annotation.QgOrderBy;
import it.quix.framework.core.codegen.annotation.QgSearchField;
import it.quix.framework.core.codegen.annotation.QgSortable;
import it.quix.framework.core.codegen.annotation.SearchFieldType;
import it.quix.framework.core.converter.annotation.QcDateTimeType;
import it.quix.framework.core.converter.annotation.QcDateType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Table(name="oggetti")
public class Oggetto {
	@Id
	@Column(length = 11, nullable = false)
	@QgListColumnField
	@QgOrderBy(type=OrderByTypeEnum.ASC,position=1)
	@QgSortable
	public Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "proprietario")
	@QgEditField(editFieldType=SearchFieldType.COMBO_SEARCH_FIELD)
	@QgListColumnField
	@QgSearchField
	public Soggetto proprietario;
	
	@Column(length = 255)
	@QgListColumnField
	@QgOrderBy(type=OrderByTypeEnum.ASC,position=0)
	@QgSortable
	@QgSearchField
	public String titolo;
	
	@Column
	@Lob 
	public String descrizione;
	
	@Column(length = 255)
	@QgAttribute(type="QBO001_categoria")
	@QgListColumnField
	@QgSearchField
	public String categoria;
	
	@Column
	@Lob 
	@QgListColumnField
	public String immagine;
	
	@Column(name="data_ultima_modifica",nullable=false)
	@QcDateTimeType
	@QgListColumnField

	@Temporal(TemporalType.TIMESTAMP) 
	public Date dataUltimaModifica;
	
	
	
}
