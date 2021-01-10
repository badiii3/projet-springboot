package com.badi.camion.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFr;
	private String nomFr;
	private String descriptionFr;
	
	@JsonIgnore
	@OneToMany(mappedBy = "fournisseur")
	private List<Camion> camions;
	



	
	
}
