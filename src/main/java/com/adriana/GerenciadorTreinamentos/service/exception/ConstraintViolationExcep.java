package com.adriana.GerenciadorTreinamentos.service.exception;

public class ConstraintViolationExcep extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public  ConstraintViolationExcep(String msg) {
		super(msg);
	}

	public  ConstraintViolationExcep(String msg, Throwable cause) {
		super(msg, cause);
	}
}
