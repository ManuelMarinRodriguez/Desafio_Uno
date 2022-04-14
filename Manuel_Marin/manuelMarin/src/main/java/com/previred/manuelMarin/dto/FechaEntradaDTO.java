package com.previred.manuelMarin.dto;

import java.util.ArrayList;

import lombok.Data;



@Data
public class FechaEntradaDTO {
	public String id;
	public String fechaCreacion;
	public String fechaFin;
	public ArrayList<String> fechas;
}
