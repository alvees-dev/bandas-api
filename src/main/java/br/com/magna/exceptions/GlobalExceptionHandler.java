package br.com.magna.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.magna.dto.JsonResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PessoaNotFoundException.class)
	public ResponseEntity<Object> handlePessoaNotFoundException(PessoaNotFoundException pnfe) {
		String erro = pnfe.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(erro), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PessoaBadRequestException.class)
	public ResponseEntity<Object> handlePessoaBadRequestException(PessoaBadRequestException pbre) {
		String erro = pbre.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(erro), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BandaNotFoundException.class)
	public ResponseEntity<Object> handleBandaNotFoundException(BandaNotFoundException bnfe) {
		String erro = bnfe.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(erro), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BandaBadRequestException.class)
	public ResponseEntity<Object> handleBandaBadRequestException(BandaBadRequestException bbre) {
		String erro = bbre.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(erro), HttpStatus.BAD_REQUEST);
	}

}
