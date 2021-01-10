package com.badi.camion.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.badi.camion.entities.Camion;
import com.badi.camion.service.CamionService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class CamionRESTController {

	@Autowired
	CamionService camionService;
	
	@RequestMapping(method=RequestMethod.GET)
	List<Camion> getAllCamions(){
		return camionService.getAllCamions();
	}


	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Camion getCamionById(@PathVariable("id") Long id) {
	return camionService.getCamion(id);
}
	
	@RequestMapping(method = RequestMethod.POST)
	public Camion createCamion(@RequestBody Camion camion) {
	return camionService.saveCamion(camion);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Camion updateCamion(@RequestBody Camion camion) {
	return camionService.updateCamion(camion);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteCamion(@PathVariable("id") Long id)
	{
	camionService.deleteCamionById(id);
	}
	
	@RequestMapping(value="/cmFr/{idFr}",method = RequestMethod.GET)
	public List<Camion> getCamionByAlId(@PathVariable("idFr") Long idFr) {
	return camionService.findByfournisseurIdFr(idFr);
	}



}
