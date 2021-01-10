package com.badi.camion.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.badi.camion.entities.Camion;
import com.badi.camion.entities.Fournisseur;

public interface CamionService {
	Camion saveCamion(Camion c);
	Camion updateCamion(Camion c);
	void deleteCamion(Camion c);
	 void deleteCamionById(Long id);
	 Camion getCamion(Long id);
	List<Camion> getAllCamions();
	Page<Camion> getAllCamionsParPage(int page, int size);
	
	
	List<Camion> findByModelCamion(String modelCamion);
	 List<Camion> findByModelCamionContains(String modelCamion);
	 List<Camion> findByModelPrix(String model, Double prix);
 List<Camion> findByFournisseur (Fournisseur fournisseur);
	 
	 List<Camion> findByfournisseurIdFr(Long id);
	 List<Camion> findByOrderByModelCamionAsc();
	 List<Camion> trierCamionsModelsPrix ();


}
