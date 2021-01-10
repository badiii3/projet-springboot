package com.badi.camion.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "modelCamion", types = { Camion.class })
public interface CamionProjection {
	public String getModel();


}