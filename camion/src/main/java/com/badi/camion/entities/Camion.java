package com.badi.camion.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;




@Entity
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idCamion;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String modelCamion;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixCamion;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
private Date dateFabrication;
	
	@ManyToOne
	private Fournisseur fournisseur;
	
	
	
	public Camion() {
		super();
	}
	
	
	
	public Camion(String modelCamion, Double prixCamion, Date dateFabrication) {
		super();
		
		this.modelCamion = modelCamion;
		this.prixCamion = prixCamion;
		this.dateFabrication = dateFabrication;
	}
	public Long getIdCamion() {
		return idCamion;
	}
	public void setIdCamion(Long idCamion) {
		this.idCamion = idCamion;
	}
	public String getModelCamion() {
		return modelCamion;
	}
	public void setModelCamion(String modelCamion) {
		this.modelCamion = modelCamion;
	}
	public Double getPrixCamion() {
		return prixCamion;
	}
	public void setPrixCamion(Double prixCamion) {
		this.prixCamion = prixCamion;
	}
	public Date getDateFabrication() {
		return dateFabrication;
	}
	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}



	@Override
	public String toString() {
		return "Camion [idCamion=" + idCamion + ", modelCamion=" + modelCamion + ", prixCamion=" + prixCamion
				+ ", dateFabrication=" + dateFabrication + "]";
	}




	
	
	
	
	
	
	
	
}
