package br.com.magna.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.magna.dto.JsonResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PessoaNotFoundException.class)
	public ResponseEntity<Object> handlePessoaNotFoundException(PessoaNotFoundException pnfe) {
		String error = pnfe.getMessage();

		return new ResponseEntity<>(new JsonResponse(error), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BandaNotFoundException.class)
	public ResponseEntity<Object> handleBandaNotFoundException(BandaNotFoundException bnfe) {
		String error = bnfe.getMessage();

		return new ResponseEntity<>(new JsonResponse(error), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ShowNotFoundException.class)
	public ResponseEntity<Object> handleShowNotFoundException(ShowNotFoundException snfe) {
		String error = snfe.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(error), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataTerminoAntesDataInicio.class)
	public ResponseEntity<Object> handleDataTerminoAntesDataInicio(DataTerminoAntesDataInicio dtadi) {
		String error = dtadi.getMessage();
		
		return new ResponseEntity<>(new JsonResponse(error), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> tratarErro400(MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
	}
	
	

	private record DadosErroValidacao(String campo, String mensagem) {
		
		public DadosErroValidacao(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
