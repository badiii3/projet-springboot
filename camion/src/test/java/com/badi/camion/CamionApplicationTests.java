package com.badi.camion;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.badi.camion.entities.Camion;
import com.badi.camion.entities.Fournisseur;
import com.badi.camion.repos.CamionRepository;
import com.badi.camion.service.CamionService;

@SpringBootTest
class CamionApplicationTests {

	@Autowired
	private CamionRepository camionRepository;
	
	@Autowired
	private CamionService camionService;
	
	@Test
	public void testCreateCamion() {
	Camion cm = new Camion("tstcamion",100000.0,new Date());
	camionRepository.save(cm);
	}
	
	
	@Test
	public void testFindCamion()
	{
	Camion cm = camionRepository.findById(1L).get();
	System.out.println(cm);
	}
	@Test
	public void testUpdateCamion()
	{
	Camion cm = camionRepository.findById(1L).get();
	cm.setPrixCamion(1000.0);
	camionRepository.save(cm);
	}
	@Test
	public void testDeleteCamion()
	{
		camionRepository.deleteById(1L);;
		}

		@Test
		public void testListerTousCamions()
		{
		List<Camion> cm = camionRepository.findAll();
		for (Camion c : cm)
		{
		System.out.println(c);
		}
		}
		
		@Test
		public void testFindByNomProduitContains()
		{
		Page<Camion> cm = camionService.getAllCamionsParPage(0,2);
		System.out.println(cm.getSize());
		System.out.println(cm.getTotalElements()); System.out.println(cm.getTotalPages());
		cm.getContent().forEach(c -> {System.out.println(c.toString());
		});
		/*ou bien
		for (Camion c : cm)
		{
		System.out.println(c);
		} */
		}

	
		
		@Test
		public void testFindByModelCamion()
		{
		List<Camion> cm = camionRepository.findByModelCamion("dmax");
		for (Camion c: cm)
		{
		System.out.println(c);
		}
		}
		@Test
		public void testFindByModelCamionContains ()
		{
		List<Camion> cm=camionRepository.findByModelCamionContains("dmax");
		for (Camion c : cm)
		{
		System.out.println(c);
		} }
		
		
		
		@Test
		public void testfindByModelPrix()
		{
		List<Camion> cm = camionRepository.findByModelPrix("dmax", 1000.0);
		for (Camion c : cm)
		{
		System.out.println(c);
		}
		}
		
		@Test
		public void testfindByFournisseur()
		{
		Fournisseur fr = new Fournisseur();
		fr.setIdFr(1L);
		List<Camion> cm = camionRepository.findByFournisseur(fr);
		for (Camion c : cm)
		{
		System.out.println(c);
		}
		}

		
		@Test
		public void findByFournisseurIdFr()
		{
		List<Camion> cm = camionRepository.findByfournisseurIdFr(1L);
		for (Camion c : cm)
		{
		System.out.println(c);
		}
		 }

		@Test
		public void testfindByOrderByModelCamionAsc()
		{
		List<Camion> cm =
		camionRepository.findByOrderByModelCamionAsc();
		for (Camion c : cm)
		{
		System.out.println(c);
		}
		}


		@Test
		public void testTrierCamionsModelsPrix()
		{
		List<Camion> cm = camionRepository.trierCamionsModelsPrix();
		for (Camion c : cm)
		{
		System.out.println(c);
		}
		}

}