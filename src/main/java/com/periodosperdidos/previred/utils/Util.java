package com.periodosperdidos.previred.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.periodosperdidos.previred.model.PeriodoAleatorio;

/**
 * 
 * @author Julio Jaimes
 * @apiNote Class has the solution of the Nivel 3.
 */
@Component("util")
public class Util {

	/**
	 * 
	 * @param periodos
	 * @return List of dates(Fechas faltantes)
	 */
	public List<LocalDate> solution(PeriodoAleatorio periodos) {

		List<LocalDate> dates = periodos.getFechas();
		List<LocalDate> datesNew = new ArrayList<LocalDate>();

		// Add all dates between FechaCreacion and first date into de Fechas
		datesNew.addAll(listDatesBetweenTwoDates(periodos.getFechaCreacion(), dates.get(0)));

		// Add FechaCreacion if it is not into the Fechas generates by Generador de
		// Dates API
		if (!dates.contains(periodos.getFechaCreacion())) {
			datesNew.add(0, periodos.getFechaCreacion());
		}

		for (int i = 0; i < dates.size() - 1; i++) {

			datesNew.addAll(listDatesBetweenTwoDates(dates.get(i), dates.get(i + 1)));

		}

		// Add all dates the last date into the list Fechas and the last date FechaFin
		datesNew.addAll(listDatesBetweenTwoDates(dates.get(dates.size() - 1), periodos.getFechaFin()));

		// Add FechaFin if it is not into the Fechas generates by Generador de Dates API
		if (!dates.contains(periodos.getFechaFin())) {
			datesNew.add(periodos.getFechaFin());
		}

		return datesNew;
	}

	/**
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return List dates between two dates respectively
	 */
	public List<LocalDate> listDatesBetweenTwoDates(LocalDate dateStart, LocalDate dateEnd) {

		List<LocalDate> dates = new ArrayList<LocalDate>();

		Period p = Period.between(dateStart, dateEnd);

		for (int j = 1; j < p.getMonths(); j++) {

			dates.add(dateStart.plusMonths(j));
		}

		return dates;
	}

}
