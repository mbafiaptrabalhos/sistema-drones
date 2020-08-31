package br.com.fiap.sistema.drones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(value = DroneNaoEncontradoException.class)
	public ResponseEntity<Void> handleGenericNotFoundException(DroneNaoEncontradoException e) {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
}
