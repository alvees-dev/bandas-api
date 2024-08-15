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
		//List<String> erros = new ArrayList<>();
		String erro = pnfe.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(erro), HttpStatus.BAD_REQUEST);
	}
	

}
