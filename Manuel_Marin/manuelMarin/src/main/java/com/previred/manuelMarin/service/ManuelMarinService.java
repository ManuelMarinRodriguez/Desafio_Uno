package com.previred.manuelMarin.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.previred.manuelMarin.dto.FechaEntradaDTO;
import com.previred.manuelMarin.dto.FechaSalidaDTO;
import com.previred.manuelMarin.util.Constantes;
import com.previred.manuelMarin.util.Utils;

@Service
public class ManuelMarinService {


	/**
	 * Metodo que retorna las fechas del servicio
	 * ya procesadas
	 * @return
	 */
	public FechaSalidaDTO retornoFechaProcesada() {
		
		ArrayList<String> fechasFaltantes = new ArrayList<String>();
		FechaSalidaDTO fachasSalidaDTO = new FechaSalidaDTO();
		int vector[]= new int [100];
		String fechas[]= new String [100];
        RestTemplate plantilla = new RestTemplate();
	    try {    
	        FechaEntradaDTO fecha = plantilla.getForObject(Constantes.URL_SERVICIO, FechaEntradaDTO.class);
	        System.out.println("getFechaFin " + fecha.getFechaFin());
	        System.out.println("getFechaCreacion " + fecha.getFechaCreacion());
	        System.out.println("getId " + fecha.getId());
	        System.out.println("getFechas " + fecha.getFechas());
	        if (fecha.getFechas().size() > 100) {
				
	           fachasSalidaDTO.setId(Constantes.SCOD_ERROR);
	           fachasSalidaDTO.setFechaCreacion(fecha.getFechaCreacion());
	  	       fachasSalidaDTO.setFechaFin(fecha.getFechaFin());
	  	       fachasSalidaDTO.setFechaCreacion(fecha.getFechaCreacion());
	  	       fachasSalidaDTO.setFechas(fecha.getFechas());
			}else {
	        
	        int pocisionVecto = fechasIniciales(vector, fechas, fecha);
	        
	       /** Metodo que deja rescata las fechas faltantes*/ 
	       fechasFaltantes = Utils.fechasFaltantes(vector, fecha.getFechas(), fecha.getFechaCreacion(),
	        		fecha.getFechaFin(), pocisionVecto); 
	       
	       fachasSalidaDTO.setId(Constantes.SCOD_SUCCES);
	       fachasSalidaDTO.setFechaCreacion(fecha.getFechaCreacion());
	       fachasSalidaDTO.setFechaFin(fecha.getFechaFin());
	       fachasSalidaDTO.setFechaCreacion(fecha.getFechaCreacion());
	       fachasSalidaDTO.setFechas(fecha.getFechas());
	       fachasSalidaDTO.setFechasFaltantes(fechasFaltantes);
			}
	    }catch (RestClientException  ex) {
	    	System.out.println("Error al conectarse al servicio");
	    	fachasSalidaDTO.setId(Constantes.SCOD_ERROR_CONECCION);
	    	
	    }
	    
	       return fachasSalidaDTO;
		
		
	}
	
	/**
	 * Metodo que extrae las fechas iniciales
	 * @param vector
	 * @param fechas
	 * @param fecha
	 * @return
	 */
	private int fechasIniciales(int[] vector, String[] fechas, FechaEntradaDTO fecha) {
		int año = Integer.parseInt(fecha.getFechaCreacion().substring(0, 4));
		String añoString =  Integer.toString(año);
		int pocisionVecto = 1;
		vector[0] = 0;
		int variableRecorrido = 0;
		/** Ciclo de deja las fechas iniciales en el vector*/
		for (int i = 0; i < fecha.getFechas().size(); i++) {
			
			if (añoString.equals(fecha.getFechas().get(i).substring(0, 4))) {
				fechas[i] = fecha.getFechas().get(i).substring(0, 4);
				
				}else {
					añoString = fecha.getFechas().get(i).substring(0, 4);
					fechas[i] = fecha.getFechas().get(i).substring(0, 4);
					vector[pocisionVecto] = i;
					pocisionVecto++;
				}
			
			variableRecorrido= i;
		}
		if (variableRecorrido != fecha.getFechas().size()) {
			int pocision = fecha.getFechas().size();
			pocisionVecto = pocisionVecto++;
			fechas[pocisionVecto] = fecha.getFechas().get(pocision - 1).substring(0, 4);
			vector[pocisionVecto] = pocision - 1;
		}
		return pocisionVecto;
	}


}
