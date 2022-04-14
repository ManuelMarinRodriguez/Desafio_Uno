package com.previred.manuelMarin.util;

/**
 * 
 * @author mmarinro
 *
 */
public class Constantes {
	
	/** Constante que tiene definida enpoint de MS GDD */
	public static String URL_SERVICIO = "http://127.0.0.1:8080/periodos/api";
	
	/** Constante que tiene defiido ID de exito*/
	public static String SCOD_SUCCES = "1";
	
	/** Constante que tiene definida error por limite de fechas superado */
	public static String SCOD_ERROR = "2 - Fechas entregadas por MS GDD son mas de 100";
	
	/** Constante que tiene definida error por limite de fechas superado */
	public static String SCOD_ERROR_CONECCION = "3 - Error al intentar conectar con MS GDD";
	
	/** Constante que tiene campo SI */
	public static String SCOD_SI = "SI";
	
	/** Constante que tiene campo NO */
	public static String SCOD_NO = "NO";

}
