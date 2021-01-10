package com.badi.camion.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.badi.camion.entities.Camion;
import com.badi.camion.entities.Fournisseur;

@RepositoryRestResource(path = "rest")

public interface CamionRepository extends JpaRepository<Camion, Long> {
	
	List<Camion> findByModelCamion(String modelCamion);
	 List<Camion> findByModelCamionContains(String modelCamion);
	 
	 
	/* @Query("select c from Camion c where c.modelCamion like %?1 and c.prixCamion > ?2")
	 List<Camion> findByModelPrix (String model, Double prix);*/
	 @Query("select c from Camion c where c.modelCamion like %:model and c.prixCamion > :prix")
	 List<Camion> findByModelPrix (@Param("model") String model,@Param("prix") Double prix);
	 
	 @Query("select c from Camion c where c.fournisseur = ?1")
	 List<Camion> findByFournisseur (Fournisseur fournisseur);
	 
	 List<Camion> findByfournisseurIdFr(Long id);
	 List<Camion> findByOrderByModelCamionAsc();

	 @Query("select c from Camion c order by c.modelCamion ASC, c.prixCamion DESC")
	 List<Camion> trierCamionsModelsPrix ();




}
