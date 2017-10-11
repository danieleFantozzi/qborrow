package it.quix.academy.core.pseudo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import it.quix.framework.core.codegen.annotation.OrderByTypeEnum;
import it.quix.framework.core.codegen.annotation.QgLabel;
import it.quix.framework.core.codegen.annotation.QgListColumnField;
import it.quix.framework.core.codegen.annotation.QgOrderBy;
import it.quix.framework.core.codegen.annotation.QgSearchField;
import it.quix.framework.core.codegen.annotation.QgSortable;
import it.quix.framework.core.converter.annotation.QcDateTimeType;
import it.quix.framework.core.converter.annotation.QcDateType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

@Table(name="soggetti")
public class Soggetto {

	@Id
	@QgListColumnField
	@Column(length = 50, nullable = false)
	@QgSearchField
	public String username;
	
	@Column(length = 100, nullable = false)
	@QgListColumnField
	@QgSearchField
	public String email;
	
	@Column(name="ragione_sociale" ,length = 255)
	@QgListColumnField
	@QgSearchField
	public String ragioneSociale;
	
	@Column(length = 50, nullable = false)
	@QgListColumnField
	@QgOrderBy(type=OrderByTypeEnum.ASC,position=1)
	@QgSortable
	@QgSearchField
	public String nome;
	
	@Column(length = 50, nullable = false)
	@QgListColumnField
	@QgOrderBy(type=OrderByTypeEnum.ASC,position=0)
	@QgSortable
	@QgSearchField
	public String cognome;
	
	@Column
	@Lob
	@QgListColumnField
	public String immagine;
	
	@Column(name="data_ultima_modifica",nullable=false)
	@QcDateTimeType
	@QgListColumnField
	@Temporal(TemporalType.TIMESTAMP) 
	public Date dataUltimaModifica;
	
	@OneToMany(mappedBy="proprietario")
	
	public Set<Oggetto> oggetti;
	
	@OneToMany(mappedBy="beneficiario")
	
	public Set<Prestito> beneficiarioPrestiti;

}
