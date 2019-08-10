package com.periodosperdidos.previred.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.periodosperdidos.previred.converter.ConvertModel;
import com.periodosperdidos.previred.exception.ApiError;
import com.periodosperdidos.previred.model.PeriodoAleatorio;
import com.periodosperdidos.previred.model.ResponseModel;
import com.periodosperdidos.previred.utils.WriteFileInputOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Julio Jaimes.
 *
 */
@Api(value = "api/v1.0")
@RestController
@RequestMapping("/api/v1.0/previred/desafio")
public class RestControllerPrincipal {

	private static final String URL_API = "http://127.0.0.1:8080/periodos/api";
	private static final String NAME_FILE = "salida.json";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private WriteFileInputOutput writer;

	@Autowired
	@Qualifier("convertModel")
	private ConvertModel convertModel;

	@ApiOperation(value = "Despliega la lista de Fechas y Fechas faltantes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Operacion exitosa"),
			@ApiResponse(code = 409, message = "La Api externa no responde correctamente o se encuentra fuera de servicio") })
	@GetMapping("/")
	public ResponseEntity<?> solution() throws IOException {

		try {

			PeriodoAleatorio periodos = restTemplate.getForObject(URL_API, PeriodoAleatorio.class);
			ResponseModel response = convertModel.convertPeriodosAleatorioToResponseModel(periodos);

			// Writer the response in the salida file
			writer.writeSolution("previred", NAME_FILE, mapper.writeValueAsString(response));

			return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
		} catch (Exception e) {

			ApiError errorBody = new ApiError(HttpStatus.CONFLICT, e.getMessage(), e.getCause().getMessage());
			// write the error into salida file
			writer.writeSolution("previred", NAME_FILE, mapper.writeValueAsString(errorBody));
			return new ResponseEntity<ApiError>(errorBody, HttpStatus.CONFLICT);
		}

	}

}
