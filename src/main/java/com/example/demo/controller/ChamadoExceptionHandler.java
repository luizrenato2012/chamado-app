package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.example.demo.model.service.ChamadoException;

@ControllerAdvice
public class ChamadoExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@Override // validacao de campos nulos
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleMethodArgumentNotValid");
		return this.handleExceptionInternal(ex, this.criaListaErros(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override // erros de formato de dados
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleHttpMessageNotReadable");
		return this.handleExceptionInternal(ex, criaListaErros(ex.getMessage()), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	
	@Override //faltando parametros na requisicao
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleMissingServletRequestParameter");
		return this.handleExceptionInternal(ex, this.criaListaErros(ex.getMessage()), headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(ChamadoException.class)
	public ResponseEntity<Object> handleChamadoException(Exception ex, WebRequest request) {
		return this.handleExceptionInternal(ex, this.criaListaErros(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleConversionNotSupported");
		return super.handleConversionNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleHttpMediaTypeNotAcceptable");
		return super.handleHttpMediaTypeNotAcceptable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleHttpMediaTypeNotSupported");
		return super.handleHttpMediaTypeNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		this.logger.info(">> handleMissingPathVariable");
		return super.handleMissingPathVariable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleMissingServletRequestPart");
		return super.handleMissingServletRequestPart(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleNoSuchRequestHandlingMethod");
		return super.handleNoSuchRequestHandlingMethod(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleServletRequestBindingException"); 
		return this.handleExceptionInternal(ex, this.criaListaErros(ex.getMessage()), new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleHttpMessageNotWritable"); 
		return super.handleHttpMessageNotWritable(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		this.logger.info(">> handleHttpRequestMethodNotSupported"); 
		return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		this.logger.info(">> handleNoHandlerFoundException"); 
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		this.logger.info(">> handleTypeMismatch"); 
		return this.handleExceptionInternal(ex, this.criaListaErros(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException arg0,
			HttpHeaders arg1, HttpStatus arg2, WebRequest arg3) {
		this.logger.info(">> handleAsyncRequestTimeoutException"); 
		return super.handleAsyncRequestTimeoutException(arg0, arg1, arg2, arg3);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		this.logger.info(">> handleBindException"); 
		return this.handleExceptionInternal(ex, this.criaListaErros(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criaListaErros(BindingResult result) {
		List<Erro> listaErros = new ArrayList<Erro>();
		for(FieldError fieldError : result.getFieldErrors()) {
			listaErros.add(new Erro(this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale())));
		}
		return listaErros;
	}
	
	private List<Erro> criaListaErros(String... erros) {
		List<Erro> listaErros = new ArrayList<Erro>();
		for(String error : erros) {
			listaErros.add(new Erro(error));
		}
		return listaErros;
	}
	
	private class Erro {
		private String mensagem;
		
		public Erro(String mensagem) {
			super();
			this.mensagem = mensagem;
		}
		
		public Erro() {
			super();
		}

		public String getMensagem() {
			return mensagem;
		}

	}

	
	

}
