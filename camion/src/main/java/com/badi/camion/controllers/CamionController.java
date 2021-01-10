package com.badi.camion.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.badi.camion.entities.Camion;
import com.badi.camion.service.CamionService;

@Controller
public class CamionController {
	
	@Autowired
	CamionService camionService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("camion", new Camion());
		
		modelMap.addAttribute("mode", "new");

	return"formCamion";
	}


	@RequestMapping("/saveCamion")
	public String saveCamion(@ModelAttribute("camion") Camion camion,
			 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "formCamion";
			camionService.saveCamion(camion);
	return"formCamion";
	}
	
	
	@RequestMapping("/listeCamion")
	public String listeCamion(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Camion> cm = camionService.getAllCamionsParPage(page, size);
		modelMap.addAttribute("camion", cm);
		modelMap.addAttribute("pages", new int[cm.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeCamion";
	}
	
	
	@RequestMapping("/supprimerCamion")
	public String supprimerCamion(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	                   @RequestParam (name="size", defaultValue = "2") int size)
	{
	camionService.deleteCamionById(id);
	
	Page<Camion> cm = camionService.getAllCamionsParPage(page, size);
	modelMap.addAttribute("camion", cm);
	modelMap.addAttribute("pages", new int[cm.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeCamion";
	}
	
	
	@RequestMapping("/modifierCamion")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Camion cm= camionService.getCamion(id);
	modelMap.addAttribute("camion", cm);
	modelMap.addAttribute("mode", "edit");
	return "formCamion";
	}
	@RequestMapping("/updateCamion")
	public String updateCamion(@ModelAttribute("camion") Camion camion,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateFabrication = dateformat.parse(String.valueOf(date));
	 camion.setDateFabrication(dateFabrication);

	 camionService.updateCamion(camion);
	 List<Camion> cm = camionService.getAllCamions();
	 modelMap.addAttribute("camion", cm);
	return "listeCamion";
	}

	
	}
	
	
	

