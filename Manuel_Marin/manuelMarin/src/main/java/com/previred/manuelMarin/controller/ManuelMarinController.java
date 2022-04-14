package com.previred.manuelMarin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.previred.manuelMarin.dto.FechaSalidaDTO;
import com.previred.manuelMarin.service.ManuelMarinService;



/**
 * 
 * @author mmarinro
 *
 */
@RestController
@CrossOrigin
public class ManuelMarinController {

	@Autowired(required = true)
	ManuelMarinService service;
	/**
	 * Consta la venta por el numero de boleta
	 * @param numero
	 * @return
	 */
	@GetMapping("/validacionFecha")
	public FechaSalidaDTO fechasProcesada() {
		System.out.println("Verifucar Consulta fecha");
		return service.retornoFechaProcesada();

	}
	
	
	
	
}
