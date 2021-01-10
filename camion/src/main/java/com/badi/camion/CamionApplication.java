package com.badi.camion;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.badi.camion.entities.Camion;
import com.badi.camion.service.CamionService;

@SpringBootApplication
public class CamionApplication implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(CamionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Camion.class);
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		/*camionService.saveCamion(new Camion("SCANIA", 260000.0, new Date()));
		camionService.saveCamion(new Camion("TOYOTA", 95000.0, new Date()));
		camionService.saveCamion(new Camion("RENAULT", 90000.0, new Date()));
		
	}*/

}
