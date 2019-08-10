package com.periodosperdidos.previred.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.periodosperdidos.previred.model.PeriodoAleatorio;
import com.periodosperdidos.previred.model.ResponseModel;
import com.periodosperdidos.previred.utils.Util;

/**
 * 
 * @author Julio Jaimes.
 * @apiNote This class is used to convert response our system. The solution is
 *          active when set FechasFaltantes as you can see
 *
 */
@Component("convertModel")
public class ConvertModel {

	@Autowired
	@Qualifier("util")
	private Util util;

	public ResponseModel convertPeriodosAleatorioToResponseModel(PeriodoAleatorio periodosAleatorios) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setId(periodosAleatorios.getId());
		responseModel.setFechaCreacion(periodosAleatorios.getFechaCreacion());
		responseModel.setFechaFin(periodosAleatorios.getFechaFin());
		responseModel.setFechas(periodosAleatorios.getFechas());
		responseModel.setFechasFaltantes(util.solution(periodosAleatorios));

		return responseModel;
	}

}
