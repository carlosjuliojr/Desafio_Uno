package com.periodosperdidos.previred.model;

import java.time.LocalDate;
import java.util.List;

/**
 * 
 * @author Julio Jaimes
 * @apiNote Class is used to store the response of the API generador de fechas
 */
public class PeriodoAleatorio {

	private Long id;

	private LocalDate fechaCreacion;

	private LocalDate fechaFin;

	private List<LocalDate> fechas;

	public PeriodoAleatorio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

}
