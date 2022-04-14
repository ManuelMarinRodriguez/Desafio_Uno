package com.previred.manuelMarin.util;

import java.util.ArrayList;

public class Utils {
	
	/**
	 * 
	 * @param vector
	 * @param fechas
	 * @param fechaCreacion
	 * @param fechaFin
	 * @param largo
	 * @return
	 */
	public static ArrayList<String> fechasFaltantes(int[] vector, ArrayList<String> fechas, String fechaCreacion,
			String fechaFin, int largo) {
		
		String fechaFinValidacion = null;
		int meses[]= new int [12];
		ArrayList<String> fechasFaltantes = new ArrayList<String>();

		for (int i = 0; i <= largo-1; i++) {
			int mesInicial = Integer.parseInt(fechas.get(vector[i]).substring(5,7));
			int añoInicial = Integer.parseInt(fechas.get(vector[i]).substring(0,4));
			int inicio =  vector[i];
			int fin = vector[i+1];
			int variable = 1;
			meses[variable] = mesInicial;
			int mesInicio = validaMesInicio(fechaCreacion.substring(5, 7));
			for (int j = inicio; j < fin; j++) {
				int añoCorrelativo = Integer.parseInt(fechas.get(j).substring(0,4));
				
				
				if (añoInicial == añoCorrelativo ) {
					int mesCorrelativo = Integer.parseInt(fechas.get(j).substring(5,7));
					if (mesInicial != mesCorrelativo) {
						variable++;
						meses[variable] = mesCorrelativo;
						mesInicial = mesCorrelativo;
					}
					String comprobacion = Constantes.SCOD_NO;
					if (j == fin-1) {
						for (int m = mesInicio; m < 13; m++) {
							
							for (int k = 1; k <= variable; k++) {
								if (m == meses[k]) {
									comprobacion = Constantes.SCOD_SI;
								}
								
							}
							
							if (comprobacion.endsWith(Constantes.SCOD_NO)) {
								
								String año = añoInicial + "-";
								String mes;
								String dia = "-01";
								if (m > 9) {
									mes =  Integer.toString(m);
								}else {
									mes =  "0" + Integer.toString(m);
								}
								
								fechasFaltantes.add(año + mes + dia);
								fechaFinValidacion = año + mes + dia;
								comprobacion = Constantes.SCOD_NO;
								
							}else{
								comprobacion = Constantes.SCOD_NO;
							}
						}
						// Se deja valor a 1 validacion de primera ejecución
						mesInicio = 1;
						
						
					}
				
				} 

				}
		}
		
		return fechasFaltantes;
	}
	
	
	/**
	 * Validacion para otorgarle valor al mes inicial de las fechas a rescatar faltantes
	 * @param substring
	 * @return
	 */
	private static int validaMesInicio(String mesInicial) {
		
		int mesInicio = Integer.parseInt(mesInicial);
		
		if (mesInicio == 12) {
			mesInicio = 1;
		}else
		{
			mesInicio++;
		}
		
		return mesInicio;
	}



}
