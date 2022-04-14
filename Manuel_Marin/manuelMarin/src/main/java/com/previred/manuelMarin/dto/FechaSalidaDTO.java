package com.previred.manuelMarin.dto;

import java.util.ArrayList;

import lombok.Data;



@Data
public class FechaSalidaDTO {
	public String id;
	public String fechaCreacion;
	public String fechaFin;
	public ArrayList<String> fechas;
	public ArrayList<String> fechasFaltantes;
}
